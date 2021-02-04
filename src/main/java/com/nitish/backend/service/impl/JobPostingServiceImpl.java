package com.nitish.backend.service.impl;

import com.nitish.backend.model.entity.JobPosting;
import com.nitish.backend.parser.JobPortalParser;
import com.nitish.backend.repository.JobPostingRepository;
import com.nitish.backend.service.FileService;
import com.nitish.backend.service.JobPostingService;
import com.nitish.backend.service.WebScraperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class JobPostingServiceImpl implements JobPostingService {
    @Autowired
    private WebScraperService webScraperService;

    @Autowired
    private FileService fileService;

    @Autowired
    private JobPortalParser jobPortalParser;

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Override
    public void loadJobPostingFile(int jobId) {
        String data = webScraperService.downloadJobPostingFile(jobId);
        String fileName = getFileName();

        // write CSV string returned by web scraper API to a file
        fileService.writeCSVStringToFile(fileName, data);

        // convert CSV file data to a list (ready for parsing)
        List<String[]> csvData = fileService.readCSVFile(fileName);

        // Parse CSV data (ready to save into the database)
        Set<JobPosting> jobPostings = jobPortalParser.parse(csvData);

        // dump csv data list into the database
        jobPostings.forEach(this::saveJobPosting);
    }

    private void saveJobPosting(JobPosting jobPosting) {
        try {
            jobPostingRepository.save(jobPosting);
        } catch (Exception exception) {
            log.error("Job posting couldn't be saved to the database: {}", jobPosting);
        }
    }

    private String getFileName() {
        return "scraped-data/data_" + System.currentTimeMillis() / 1000L + ".csv";
    }
}
