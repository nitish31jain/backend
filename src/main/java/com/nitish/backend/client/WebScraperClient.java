package com.nitish.backend.client;

import com.nitish.backend.model.dto.webscraper.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;

@Component
@Slf4j
public class WebScraperClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${web-scraper.url.base}")
    private String baseUrl;

    @Value("${web-scraper.url.account-info-path}")
    private String accountInfoPath;

    @Value("${web-scraper.url.download-csv-path}")
    private String downloadCsvPath;

    @Value("${web-scraper.auth.token}")
    private String authToken;

    public AccountInfo retrieveAccountInfo() {
        HttpEntity<String> entity = new HttpEntity<String>(getHeaders());
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat(accountInfoPath))
                .buildAndExpand(authToken).encode().toUri();

        ResponseEntity<AccountInfo> response =
                restTemplate.exchange(uri, HttpMethod.GET, entity, AccountInfo.class);

        return response.getBody();
    }

    public String downloadJobPostingFile(int jobId) {
        HttpEntity<String> entity = new HttpEntity<String>(getHeaders());
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl.concat(downloadCsvPath))
                .buildAndExpand(jobId, authToken).encode().toUri();

        ResponseEntity<String> response =
                restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-COM-TRANSACTION_ID", "12345678");
        return headers;
    }
}