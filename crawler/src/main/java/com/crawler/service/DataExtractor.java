/**
 *
 */
package com.crawler.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Api to extract data from a link.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface DataExtractor {
    /**
     * Get document object of an http link.
     *
     * @param url
     * @return html Document object
     */
    public Document getDocument(final String url);

    /**
     * Extracts links.
     *
     * @return Elements list of href links.
     */
    public Elements getHrefs(Document document);

    /**
     * Extract images.
     *
     * @return Elements list of imgs.
     */
    public Elements getImages(Document document);

    /**
     * Extract absolute urls.
     *
     * @return absolute url
     */
    public String getAbsUrl(Element element);

    /**
     * Extract page title.
     *
     * @return page title
     */
    public String getTitle(Document document);

    /**
     * Get image count.
     *
     * @return image count
     */
    public int getImageCount(Document document);

    /**
     * validate a given url.
     *
     * @param url
     * @return boolean flag
     */
    public boolean validateUrl(final String url);

}
