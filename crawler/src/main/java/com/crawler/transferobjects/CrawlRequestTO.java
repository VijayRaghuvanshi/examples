package com.crawler.transferobjects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Crawl requrest class.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class CrawlRequestTO {

    @NotNull(message="Add depth between 1 to 4")
    @Min(value=1, message="Depth value cann't be less then 1")
    private Integer depth;

    @NotBlank(message="URL is mandatory.")
    private String url;

    /**
     *
     * Getter of {@link #depth}.
     *
     * @return {@link #depth}
     */
    public Integer getDepth() {
        return depth;
    }
    /**
     *
     * Getter of {@link #url}.
     *
     * @return {@link #url}
     */
    public String getUrl() {
        return url;
    }
    /**
     *
     * Setter of {@link #depth}.
     *
     * @param depth
     *            to be set
     */
    public void setDepth(Integer depth) {
        this.depth = depth;
    }
    /**
     *
     * Setter of {@link #url}.
     *
     * @param url
     *            to be set
     */
    public void setUrl(String url) {
        this.url = url;
    }


}
