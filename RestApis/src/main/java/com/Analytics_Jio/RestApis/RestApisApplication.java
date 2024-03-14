package com.Analytics_Jio.RestApis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.web.servlet.error.ErrorController;

@SpringBootApplication
public class RestApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApisApplication.class, args);
    }
}

@RestController
@RequestMapping("/fileUpload")
class FileUploadController {

    // Define the folder path where the files will be uploaded
    private static final String UPLOAD_FOLDER = "E:\\Files";

    @GetMapping("/get")
    public String index() {
        return "uploadForm";
    }

    @PostMapping("/uploadFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Get the bytes of the uploaded file
            byte[] bytes = file.getBytes();
            // Define the path where the file will be saved
            Path path = Paths.get(UPLOAD_FOLDER + "/" + file.getOriginalFilename());
            // Write the bytes to the specified path
            Files.write(path, bytes);
            System.out.println("File uploaded successfully to: " + path);
            // Redirect to a success page or return a success message
            return "redirect:/uploadSuccess";
        } catch (IOException e) {
            // Handle file processing errors
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        // Log the exception
        e.printStackTrace();
        // Redirect to a custom error page
        return "error";
    }
}

