package com.example.Fileupload.Controllers;


import com.example.Fileupload.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUpload {

    @Autowired
    public FileUploadService fileUploadService;

    @PostMapping("/upload/pdfs")
    public ResponseEntity<?> uploadPdfs(@RequestParam("pdf_file") MultipartFile inputFile) throws Exception {

        System.out.println("inside method");

        System.out.println(inputFile);
        fileUploadService.handlepdfUpload(inputFile);



        return ResponseEntity.status(HttpStatus.OK).body("helllo wfhtdtydctrdt");

    }

}
