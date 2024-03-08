package com.f1api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class Base64Service {
    
    public void decodeAndSaveImage(String base64Image, String gp, Integer year) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

            String fileName = gp + "-" + year + ".png";
            fileName = fileName.replaceAll("\\s", "");
            
            Path outputDirectory = Paths.get("out/");
            Files.createDirectories(outputDirectory);

            Path filePath = outputDirectory.resolve(fileName);

            Files.write(filePath, decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
