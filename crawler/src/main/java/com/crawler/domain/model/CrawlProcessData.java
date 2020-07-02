/**
 *
 */
package com.crawler.domain.model;

import com.crawler.constant.CrawlProcessStatus;

import java.util.Set;

/**
 * Crawl Domain object for persistent/cache layer.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class CrawlProcessData {

    private final String token;

    private final String rootUrl;

    private final int maxLevel;

    private int totalLinks;

    private int totalImages;

    private CrawlProcessStatus status;

    private Set<PageDetails> pageDetails;

    public CrawlProcessData(final String token, final String rootUrl,
            final int maxLevel, final CrawlProcessStatus status) {
        this.token = token;
        this.status = status;
        this.rootUrl = rootUrl;
        this.maxLevel = maxLevel;
    }

    /**
     * Inner static class for page details.
     *
     * @author vijaykumar
     * @version $Revision: 1.10 $
     */
    public static class PageDetails {
        private String title;

        private String pageLink;

        private int imageCount;

        /**
         *
         * Getter of {@link #title}.
         *
         * @return {@link #title}
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * Getter of {@link #pageLink}.
         *
         * @return {@link #pageLink}
         */
        public String getPageLink() {
            return pageLink;
        }

        /**
         *
         * Getter of {@link #imageCount}.
         *
         * @return {@link #imageCount}
         */
        public int getImageCount() {
            return imageCount;
        }

        /**
         *
         * Setter of {@link #title}.
         *
         * @param title
         *            to be set
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * Setter of {@link #pageLink}.
         *
         * @param pageLink
         *            to be set
         */
        public void setPageLink(String pageLink) {
            this.pageLink = pageLink;
        }

        /**
         *
         * Setter of {@link #imageCount}.
         *
         * @param imageCount
         *            to be set
         */
        public void setImageCount(int imageCount) {
            this.imageCount = imageCount;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((pageLink == null) ? 0 : pageLink.hashCode());
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final PageDetails other = (PageDetails) obj;
            if (pageLink == null) {
                if (other.pageLink != null)
                    return false;
            } else if (!pageLink.equals(other.pageLink))
                return false;
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder();
            builder.append("PageDetails [title=");
            builder.append(title);
            builder.append(", pageLink=");
            builder.append(pageLink);
            builder.append(", imageCount=");
            builder.append(imageCount);
            builder.append("]");
            return builder.toString();
        }

    }

    /**
     *
     * Getter of {@link #totalLinks}.
     *
     * @return {@link #totalLinks}
     */
    public int getTotalLinks() {
        return totalLinks;
    }

    /**
     *
     * Getter of {@link #totalImages}.
     *
     * @return {@link #totalImages}
     */
    public int getTotalImages() {
        return totalImages;
    }

    /**
     *
     * Setter of {@link #totalLinks}.
     *
     * @param totalLinks
     *            to be set
     */
    public void setTotalLinks(int totalLinks) {
        this.totalLinks = totalLinks;
    }

    /**
     *
     * Setter of {@link #totalImages}.
     *
     * @param totalImages
     *            to be set
     */
    public void setTotalImages(int totalImages) {
        this.totalImages = totalImages;
    }

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
     * Getter of {@link #status}.
     *
     * @return {@link #status}
     */
    public CrawlProcessStatus getStatus() {
        return status;
    }

    /**
     *
     * Getter of {@link #pageDetails}.
     *
     * @return {@link #pageDetails}
     */
    public Set<PageDetails> getPageDetails() {
        return pageDetails;
    }

    /**
     *
     * Setter of {@link #pageDetails}.
     *
     * @param pageDetails
     *            to be set
     */
    public void setPageDetails(Set<PageDetails> pageDetails) {
        int imageCount = 0;
        for (final PageDetails pageDetail : pageDetails) {
            imageCount += pageDetail.getImageCount();
        }
        synchronized (this) {
            totalImages = imageCount;
            totalLinks = pageDetails.size();
            this.pageDetails = pageDetails;
        }
    }

    /**
     *
     * Setter of {@link #status}.
     *
     * @param status
     *            to be set
     */
    public void setStatus(CrawlProcessStatus status) {
        synchronized (this) {
            this.status = status;
        }
    }

    /**
     *
     * Getter of {@link #rootUrl}.
     *
     * @return {@link #rootUrl}
     */
    public String getRootUrl() {
        return rootUrl;
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
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((pageDetails == null) ? 0 : pageDetails.hashCode());
        result = prime * result + ((rootUrl == null) ? 0 : rootUrl.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CrawlProcessData other = (CrawlProcessData) obj;
        if (pageDetails == null) {
            if (other.pageDetails != null)
                return false;
        } else if (!pageDetails.equals(other.pageDetails))
            return false;
        if (rootUrl == null) {
            if (other.rootUrl != null)
                return false;
        } else if (!rootUrl.equals(other.rootUrl))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }

}
