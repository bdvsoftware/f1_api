package com.f1api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class Base64Service {
    
    public void decodeAndSaveImage(String base64Image, String driverName, String gp, Integer year) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

            // Crear el nombre del archivo
            String fileName = driverName + "-" + gp + "-" + year + ".png";
            fileName = fileName.replaceAll("\\s", "");
            
            // Crear el directorio de salida si no existe
            Path outputDirectory = Paths.get("out/");
            Files.createDirectories(outputDirectory);

            // Crear el path completo para el archivo de imagen
            Path filePath = outputDirectory.resolve(fileName);

            // Guardar los bytes en el archivo de imagen
            Files.write(filePath, decodedBytes);

            // Guardar los bytes en el archivo de imagen
            Files.write(filePath, decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
