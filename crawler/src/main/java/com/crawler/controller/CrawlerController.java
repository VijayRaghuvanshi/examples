/**
 *
 */
package com.crawler.controller;

import com.crawler.constant.CrawlProcessStatus;
import com.crawler.domain.model.CrawlProcessData;
import com.crawler.factory.CrawlerFactory;
import com.crawler.service.CrawlerService;
import com.crawler.transferobjects.CrawlRequestTO;
import com.crawler.transferobjects.CrawlResponseTO;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes all the rest apis to interact with crawler application.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@RestController
@RequestMapping("/crawler")
public class CrawlerController {

    @Autowired
    private CrawlerFactory crawlerServiceFactory;

    /**
     * Crawl api to trigger a crawl request.
     *
     * @param crawlRequest
     * @return Token and a message for the request submitted
     */
    @PostMapping(path = "/crawl", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrawlResponseTO> crawl(
            @Valid @RequestBody final CrawlRequestTO crawlRequest) {

        final CrawlerService service = crawlerServiceFactory.getCrawler();
        final CrawlResponseTO response = service.crawl(crawlRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Api to return crawl processed response.
     *
     * @param token
     * @return
     */
    @GetMapping(path = "/process/data", produces = "application/json")
    public ResponseEntity<CrawlProcessData> getProcessedData(
            @RequestParam("token") String token) {
        final CrawlerService service = crawlerServiceFactory.getCrawler();
        return new ResponseEntity<>(service.crawlProcessData(token), HttpStatus.OK);
    }

    /**
     * Api to return processed data of completed request.
     *
     * @param token
     * @return current status of the process
     */
    @GetMapping(path = "/process/status", produces = "application/json")
    public ResponseEntity<CrawlProcessStatus> getCurrentStatus(
            @RequestParam("token") String token) {
        final CrawlerService service = crawlerServiceFactory.getCrawler();
        return new ResponseEntity<>(
                service.currentStatus(token),
                HttpStatus.OK);
    }

}
