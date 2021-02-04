package com.nitish.backend.parser.impl;

import com.nitish.backend.model.entity.JobPosting;
import com.nitish.backend.parser.JobPortalParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
@Slf4j
public class WTJJobPortalParser implements JobPortalParser {
    @Override
    public Set<JobPosting> parse(List<String[]> csvData) {
        return getJobPostings(csvData);
    }

    private Set<JobPosting> getJobPostings(List<String[]> csvData) {
        Set<JobPosting> jobPostings = new HashSet<>();
        int index = 0;
        for(String[] data: csvData) {
            if (index == 0) {
                index++;
                continue;
            };
            JobPosting jobPosting = new JobPosting();
            jobPosting.setJobName(data[2]);
            jobPosting.setCompanyName(data[3]);
            jobPosting.setJobType(data[4]);
            jobPosting.setJobLocation(data[5]);
            jobPosting.setWhenPosted(
                    data[6] != null ? getWhenPostedInDateFormat(data[6]) : null);
            jobPosting.setPortalName("Welcome to the Jungle");

            jobPostings.add(jobPosting);
        }
        return jobPostings;
    }

    private Date getWhenPostedInDateFormat(String whenPosted) {
        Date whenPostedFormatted = null;

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();

        if (whenPosted.contains("yesterday")) {
            localDate = localDate.minusDays(1);
        } else if (whenPosted.contains("days")) {
            int days = Integer.parseInt(whenPosted.replaceAll("[^0-9]", ""));
            localDate = localDate.minusDays(days);
        } else if (whenPosted.contains("last month")) {
            localDate = localDate.minusDays(30);
        } else if (whenPosted.contains("months")) {
            int months = Integer.parseInt(whenPosted.replaceAll("[^0-9]", ""));
            localDate = localDate.minusMonths(months);
        }
        whenPostedFormatted = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        return whenPostedFormatted;
    }
}