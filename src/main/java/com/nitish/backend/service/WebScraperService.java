package com.nitish.backend.service;

import com.nitish.backend.model.dto.webscraper.AccountInfo;

public interface WebScraperService {
    String downloadJobPostingFile(int jobId);
    AccountInfo retrieveAccountInfo();
}
