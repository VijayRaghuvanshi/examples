/**
 *
 */
package com.crawler.service.impl;

import com.crawler.config.CrawlerConfig;
import com.crawler.constant.CrawlProcessStatus;
import com.crawler.domain.model.CrawlProcessData;
import com.crawler.repository.CrawlDataManager;
import com.crawler.service.CrawlTaskProcessor;
import com.crawler.service.CrawlerService;
import com.crawler.transferobjects.CrawlRequestTO;
import com.crawler.transferobjects.CrawlResponseTO;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Web crawler service implementation.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@Service(value = "webCrawler")
class WebCrawlerServiceImpl implements CrawlerService {

    @Autowired
    private CrawlerConfig config;

    @Autowired
    private CrawlThreadPoolManager requestPool;

    @Autowired
    private CrawlDataManager dataManager;

    @Autowired
    private CrawlTaskProcessor processor;

    /**
     * {@inheritDoc}
     */
    @Override
    public CrawlResponseTO crawl(final CrawlRequestTO request) {
        final CrawlResponseTO response = new CrawlResponseTO();
        if (validateRequest(request, response)) {
            final String token = generateToken();
            response.setToken(token);
            dataManager.save(
                    new CrawlProcessData(
                            token,
                            request.getUrl(),
                            request.getDepth(),
                            CrawlProcessStatus.WAITING));
        }
        requestPool.submitTask(createCrawlPoolTask(response));
        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrawlProcessData crawlProcessData(String token) {
        return dataManager.getTokenData(token);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrawlProcessStatus currentStatus(String token) {
        return dataManager.getStatus(token);
    }

    /**
     * Generates token.
     *
     * @return a token for the request
     */
    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    /**
     * Verify if request is good to go.
     *
     * @param request
     * @return CrawlResponseTO
     */
    private boolean validateRequest(final CrawlRequestTO request,
            final CrawlResponseTO response) {
        final boolean flag = validateUrl(request, response);
        if (flag) {
            final int maxDepth = config.getMaxLevel();
            final StringBuilder sb = new StringBuilder(100);
            sb.append("Request has been submitted for processing.");
            if (request.getDepth() > maxDepth) {
                request.setDepth(maxDepth);
                sb.append(" Max depth is set to ").append(maxDepth);
            }
            response.setMessage(sb.toString());
        }
        return flag;
    }

    /**
     * Validate urls. As of now just provide basic url validation
     *
     * @param request
     */
    private boolean validateUrl(final CrawlRequestTO request,
            final CrawlResponseTO response) {
        boolean flag = true;
        if (!request.getUrl().startsWith("http")) {
            response.setMessage("Invalid url is provided");
            flag = false;
        }
        return flag;

    }

    /**
     * Create crawl request pool task.
     *
     * @param response
     * @return create a pool task
     */
    private CrawlPoolTask createCrawlPoolTask(final CrawlResponseTO response) {
        return new CrawlPoolTask(response.getToken(), processor);

    }

}
