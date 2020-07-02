/**
 *
 */
package com.crawler.service.impl;

import com.crawler.config.CrawlerConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Crawl thread pool manager to perform parallel processing.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@Component
public class CrawlThreadPoolManager {

    private ExecutorService crawlPool;

    @Autowired
    private CrawlerConfig cofig;


    /**
     * Submit crawl request to pool for parallel processing.
     *
     * @param task
     */
    void submitTask(final CrawlPoolTask task){
        crawlPool.submit(task);
    }

    /**
     * Initlize the thread pool for the parallel crawl processing.
     *
     */
    @PostConstruct
    private void init(){
        crawlPool = Executors.newFixedThreadPool(cofig.getThreadPoolSize());
    }

    @PreDestroy
    private void destory()
    {
        crawlPool.shutdown();
    }

}
