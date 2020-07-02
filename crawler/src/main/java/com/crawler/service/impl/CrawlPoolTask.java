/**
 *
 */
package com.crawler.service.impl;

import com.crawler.service.CrawlTaskProcessor;

/**
 * Task to be submitted to crawl thread pool for parallel processing.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
class CrawlPoolTask implements Runnable {

    private final String token;

    private final CrawlTaskProcessor processor;

    /**
     * Constructor.
     *
     * @param token
     */
    CrawlPoolTask(final String token, final CrawlTaskProcessor processor) {
        this.token = token;
        this.processor = processor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        processor.process(token);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("CrawlPoolTask [token=");
        builder.append(token);
        builder.append("]");
        return builder.toString();
    }

}
