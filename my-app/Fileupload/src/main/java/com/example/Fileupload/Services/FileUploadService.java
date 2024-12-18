package com.example.Fileupload.Services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

    public void handlepdfUpload(MultipartFile inputFile)throws Exception {

        System.out.println("inside: handlepdfUpload ");

        String filename = StringUtils.cleanPath(inputFile.getOriginalFilename());
        System.out.println("Filename: " + filename);


        String fileExt = StringUtils.getFilenameExtension(filename);
        System.out.println("File Extension: " + fileExt);


        System.out.println(fileExt);


        if( fileExt.equals("pdf") == false ){

            throw new Exception(fileExt +" is not allowed,upload pdf only ");
        }
    }
}
