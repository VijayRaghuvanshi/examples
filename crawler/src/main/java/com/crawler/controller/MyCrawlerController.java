/**
 *
 */
package com.crawler.controller;

import com.crawler.model.CrawlRequestTO;
import com.crawler.model.CrawlResponseTO;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes all the rest apis to interact with crawler application.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
@RestController
@RequestMapping("/crawler")
public class MyCrawlerController {

    /**
     * Crawl api to trigger a crawl request.
     *
     * @param crawlRequest
     * @return Token and message of the request
     */
    @PostMapping(path="/crawl", produces="application/json", consumes="application/json")
    public ResponseEntity<CrawlResponseTO> crawl(
            @Valid @RequestBody final CrawlRequestTO crawlRequest) {

        final CrawlResponseTO response = dummy();
        final ResponseEntity responseEntity = new ResponseEntity<>(
                response,
                HttpStatus.OK);
        return responseEntity;
    }

    private CrawlResponseTO dummy(){
        final CrawlResponseTO response = new CrawlResponseTO();
        response.setToken("token");
        response.setMessage("this is my dummy message");
        return response;
    }

}
