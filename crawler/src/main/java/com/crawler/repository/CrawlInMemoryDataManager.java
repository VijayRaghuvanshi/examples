/**
 *
 */
package com.crawler.repository;

import com.crawler.constant.CrawlProcessStatus;
import com.crawler.domain.model.CrawlProcessData;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * In memory crawl data manager.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@Component
public class CrawlInMemoryDataManager implements CrawlDataManager {

    private final Map<String, CrawlProcessData> crawlProcessDataContainer = new ConcurrentHashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final CrawlProcessData model) {
        crawlProcessDataContainer.putIfAbsent(model.getToken(), model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUrlDetail(String token, Set<CrawlProcessData.PageDetails> pageDetails) {
        crawlProcessDataContainer.get(token).setPageDetails(pageDetails);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrawlProcessData getTokenData(final String token) {
        return crawlProcessDataContainer.get(token);
    }

    @Override
    public void updateStatus(final String token, final CrawlProcessStatus status) {
        crawlProcessDataContainer.get(token).setStatus(status);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrawlProcessStatus getStatus(String token) {
        final CrawlProcessData data = crawlProcessDataContainer.get(token);
        return data!=null?data.getStatus():null;
    }
}
