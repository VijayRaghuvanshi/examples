/**
 *
 */
package com.crawler.service;

import com.crawler.constant.CrawlProcessStatus;
import com.crawler.domain.model.CrawlProcessData;
import com.crawler.transferobjects.CrawlRequestTO;
import com.crawler.transferobjects.CrawlResponseTO;

/**
 * Generic interface to expose crawler service.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public interface CrawlerService {

    /**
     * Service API to submit crawl request.
     *
     * @param request CrawlRequest request oject
     * @return CrawlResponseTO response object.
     */
    public CrawlResponseTO crawl(CrawlRequestTO request);

    /**
     * See status of current status.
     *
     * @param token
     * @return CrawlProcessStatus status of crawl request
     */
    public CrawlProcessStatus currentStatus(String token);

    /**
     * Retrieve crawl request processed data.
     *
     * @param token
     * @return  CrawlProcessData
     */
    public CrawlProcessData crawlProcessData(String token);

}
