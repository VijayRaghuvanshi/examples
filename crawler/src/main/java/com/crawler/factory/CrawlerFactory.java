/**
 *
 */
package com.crawler.factory;

import com.crawler.config.CrawlerConfig;
import com.crawler.constant.CrawlerType;
import com.crawler.service.CrawlerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Crawler factory class responsible to create and return appropriate crawler
 * service.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@Component
public class CrawlerFactory {

    @Autowired
    @Qualifier("webCrawler")
    private CrawlerService webCrawlerService;

    @Autowired
    private CrawlerConfig config;

    /**
     * Provide appropriate crawler service as per configuration.
     *
     * @return CrawlerService as per config
     */
    public CrawlerService getCrawler() {
          CrawlerService service = null;
        if(CrawlerType.webcrawler.name().equals(config.getCarawlerType())){
            service =  webCrawlerService;
        }
        return service;
    }

}
