package com.nitish.backend.service.impl;

import com.nitish.backend.service.FileService;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Override
    public void writeCSVStringToFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
        } catch (IOException ioException) {
            System.out.println("Couldn't write to a file");
        }
    }

    @Override
    public List<String[]> readCSVFile(String fileName) {
        List<String[]> data = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(fileName));
            data = csvReader.readAll();
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Couldn't read a file");
        }
        return data;
    }
}
