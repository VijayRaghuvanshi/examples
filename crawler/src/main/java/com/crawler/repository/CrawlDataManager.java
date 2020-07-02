/**
 *
 */
package com.crawler.repository;

import com.crawler.constant.CrawlProcessStatus;
import com.crawler.domain.model.CrawlProcessData;

import java.util.Set;

/**
 * Api to persist crawl data.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public interface CrawlDataManager {

    /**
     * Persist crawl process data.
     *
     * @param data
     */
    public void save(CrawlProcessData data);


    /**
     * update a url details using token .
     *
     * @param token
     * @param pageDetails
     */
    public void updateUrlDetail(String token,
            Set<CrawlProcessData.PageDetails> pageDetails);

    /**
     * Returns current request status for a given request.
     *
     * @param token
     * @return CrawlDomainModel
     */
    public CrawlProcessData getTokenData(String token);

    /**
     * Fetch request status.
     *
     * @param token
     * @return CrawlProcessStatus
     */
    public CrawlProcessStatus getStatus(String token);

    /**
     * Update status.
     *
     * @param staus
     */
    public void updateStatus(String token, CrawlProcessStatus staus);
}
