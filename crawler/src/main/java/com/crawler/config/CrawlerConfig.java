/**
 *
 */
package com.crawler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Crawler application configuration.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@Configuration
public class CrawlerConfig {

    @Value("${crawler.type:webcrawler}")
    private String carawlerType;

    @Value("${crawler.max-level:3}")
    private int maxLevel;

    @Value("${crawler.thread.pool-size:5}")
    private int threadPoolSize;
    /**
     *
     * Getter of {@link #carawlerType}.
     *
     * @return {@link #carawlerType}
     */
    public String getCarawlerType() {
        return carawlerType;
    }

    /**
     *
     * Getter of {@link #maxLevel}.
     *
     * @return {@link #maxLevel}
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     *
     * Getter of {@link #threadPoolSize}.
     *
     * @return {@link #threadPoolSize}
     */
    public int getThreadPoolSize() {
        return threadPoolSize;
    }


}
