package com.nitish.backend.service;

import java.util.List;

public interface FileService {
    void writeCSVStringToFile(String fileName, String data);
    List<String[]> readCSVFile(String fileName);
}