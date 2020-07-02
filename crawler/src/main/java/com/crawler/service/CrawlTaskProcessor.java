package com.crawler.service;

/**
 * Exposes api to process a crawl request.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface CrawlTaskProcessor {

    /**
     * Trigger crawling request using appropriate implementation service.
     *
     * @param token request token
     */
    public void process(String token);

}
