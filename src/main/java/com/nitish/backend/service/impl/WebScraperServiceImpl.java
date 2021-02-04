package com.nitish.backend.service.impl;

import com.nitish.backend.client.WebScraperClient;
import com.nitish.backend.model.dto.webscraper.AccountInfo;
import com.nitish.backend.service.WebScraperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebScraperServiceImpl implements WebScraperService {
    @Autowired
    private WebScraperClient webScraperClient;

    @Override
    public String downloadJobPostingFile(int jobId) {
        return webScraperClient.downloadJobPostingFile(jobId);
    }

    @Override
    public AccountInfo retrieveAccountInfo() {
        return webScraperClient.retrieveAccountInfo();
    }
}