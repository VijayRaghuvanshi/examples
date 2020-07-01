/**
 *
 */
package com.crawler.model;

/**
 * Response classs contains response data for a crawl request.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class CrawlResponseTO {

    private String token;
    private String message;
    /**
     *
     * Getter of {@link #token}.
     *
     * @return {@link #token}
     */
    public String getToken() {
        return token;
    }
    /**
     *
     * Getter of {@link #message}.
     *
     * @return {@link #message}
     */
    public String getMessage() {
        return message;
    }
    /**
     *
     * Setter of {@link #token}.
     *
     * @param token
     *            to be set
     */
    public void setToken(String token) {
        this.token = token;
    }
    /**
     *
     * Setter of {@link #message}.
     *
     * @param message
     *            to be set
     */
    public void setMessage(String message) {
        this.message = message;
    }



}
