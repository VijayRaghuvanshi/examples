/**
 *
 */
package com.crawler.service.impl;

import com.crawler.service.DataExtractor;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

/**
 * Using JSoup data extractor.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
@Component
public class JSoupDataExtractor implements DataExtractor {

    /**
     * {@inheritDoc}
     */
    @Override
    public Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        return document;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Elements getHrefs(final Document document) {
        return document!=null?document.select("a[href]"):null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Elements getImages(final Document document) {
        return document.getElementsByTag("img");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAbsUrl(final Element element) {
        return element!=null?element.attr("abs:href"):"";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle(final Document document) {
        return document!= null?document.title():"";

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validateUrl(String url) {
        return url != null && !url.trim().isEmpty() && url.startsWith("http")
                ? true : false;
    }

    @Override
    public int getImageCount(Document document) {

        final Elements ele = document!= null?document.getElementsByTag("img"):null;
        return ele != null ? ele.size() : 0;
    }

}
