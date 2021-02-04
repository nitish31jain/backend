package com.nitish.backend.parser;

import com.nitish.backend.model.entity.JobPosting;

import java.util.List;
import java.util.Set;

public interface JobPortalParser {
    Set<JobPosting> parse(List<String[]> csvData);
}
