/**
 *
 */
package com.crawler.service.impl;

import com.crawler.constant.CrawlProcessStatus;
import com.crawler.domain.model.CrawlProcessData;
import com.crawler.domain.model.UrlMetadata;
import com.crawler.repository.CrawlDataManager;
import com.crawler.service.CrawlTaskProcessor;
import com.crawler.service.DataExtractor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crawl request processor implementation.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */

@Service
public class CrawlTaskProcessorImpl implements CrawlTaskProcessor {

    @Autowired
    private CrawlDataManager dataManager;

    @Autowired
    private DataExtractor dataExtractor;

    /**
     * {@inheritDoc}
     */
    @Override
    public void process(final String token) {
        if (null != token && !token.isEmpty()) {
            final CrawlProcessData dataToBeCrawled = dataManager.getTokenData(token);
            dataToBeCrawled.setStatus(CrawlProcessStatus.PROCESSING);
            final Set<CrawlProcessData.PageDetails> pageDetails = crawlLink(dataToBeCrawled.getRootUrl(), dataToBeCrawled.getMaxLevel());
            dataManager.updateUrlDetail(token, pageDetails);
            dataManager.updateStatus(token, CrawlProcessStatus.COMPLETED);

        }
    }

    /**
     * Crawl links upto max depth and creates page details.
     *
     * @param data
     * @return
     */

    private Set<CrawlProcessData.PageDetails> crawlLink(final String rootUrl,
            final int maxDepth) {
        final Set<CrawlProcessData.PageDetails> pageDetailsCollection = new HashSet<>();
        final Set<String> processedUrlSet = new HashSet<>();
        final Queue<UrlMetadata> urlQueue = new LinkedList<>();
        // initlize with root url
        urlQueue.offer(new UrlMetadata(rootUrl, 1));
        UrlMetadata url = null;

        while (!urlQueue.isEmpty()) {
            url = urlQueue.poll();
            System.out.println("link processing " + url);
            final Document document = dataExtractor.getDocument(url.getUrl());
            final Elements linksOnPage = dataExtractor.getHrefs(document);
            final CrawlProcessData.PageDetails pageDetails = createPageDetails(
                    url.getUrl(),
                    document);
            processedUrlSet.add(url.getUrl());

            /*
             * Check conditions 1. Document should not be null because of
             * security, invalid url or network issues. 2. Url should not be
             * already processed. 3. url depth which is going to be processed
             * should not greater than maxDepth 4. Links on current url should
             * not be null
             */

            if (document != null
                    && pageDetailsCollection.add(pageDetails)
                    && url.getDepth() <= maxDepth
                    && linksOnPage != null) {

                final int nextDepth = url.getDepth() + 1;
                addLinksInQueue(
                        processedUrlSet,
                        maxDepth,
                        urlQueue,
                        linksOnPage,
                        nextDepth);
            }
            System.out.println(
                    "queue size left: "
                            + urlQueue.size()
                            + " , link processed: "
                            + url);
        }
        System.out.println(
                "total link processed:" + pageDetailsCollection.size());
        return pageDetailsCollection;
    }

    /**
     * Add next level links into queue which are to be processed.
     *
     * @param processedUrlSet
     * @param maxDepth
     * @param urlQueue
     * @param linksOnPage
     * @param nextDepth
     */
    private void addLinksInQueue(final Set<String> processedUrlSet,
            final int maxDepth, final Queue<UrlMetadata> urlQueue,
            final Elements linksOnPage, final int nextDepth) {
        String nexturl = null;
        UrlMetadata nextUrlMetadata = null;
        for (final Element element : linksOnPage) {
            nexturl = dataExtractor.getAbsUrl(element);
            if (dataExtractor.validateUrl(nexturl)
                    && !processedUrlSet.contains(nexturl)
                    && nextDepth <= maxDepth) {
                nextUrlMetadata = new UrlMetadata(nexturl, nextDepth);
                urlQueue.offer(nextUrlMetadata);
                processedUrlSet.add(nexturl);
            }
        }
    }

    /**
     * Create page details object.
     *
     * @param url
     * @param document
     * @return PageDetails page details object
     */
    private CrawlProcessData.PageDetails createPageDetails(final String url,
            final Document document) {
        final CrawlProcessData.PageDetails pageDetails = new CrawlProcessData.PageDetails();
        pageDetails.setImageCount(dataExtractor.getImageCount(document));
        pageDetails.setTitle(dataExtractor.getTitle(document));
        pageDetails.setPageLink(url);
        return pageDetails;
    }
}
