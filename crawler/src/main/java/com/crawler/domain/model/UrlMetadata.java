/**
 *
 */
package com.crawler.domain.model;

/**
 * Contains the link metadata to be processed.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class UrlMetadata {

    private final String url;

    private final int depth;

    public UrlMetadata(final String url, final int depth) {
        this.url = url;
        this.depth = depth;
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
     * Getter of {@link #depth}.
     *
     * @return {@link #depth}
     */
    public int getDepth() {
        return depth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        final UrlMetadata other = (UrlMetadata) obj;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UrlMetadata [url=");
        builder.append(url);
        builder.append(", level=");
        builder.append(depth);
        builder.append("]");
        return builder.toString();
    }

}
