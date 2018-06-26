package com.chanthol.test03.service.impl;

import com.chanthol.test03.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@PropertySource("classpath:/bms.properties")
public class UploadServiceImp implements UploadService {

    @Value("${file.client.path}")
    private String CLIENT_PATH;

    @Value("${file.server.path}")
    private String SERVER_PATH;

    @Override
    public String singleFileUploadFile(MultipartFile file, String folder) {
        if(file.isEmpty()){
            return null;
        }
        File path=new File(SERVER_PATH+folder);
        if(!path.exists())
            path.mkdirs();

        String filename=file.getOriginalFilename();
        String extension=filename.substring(filename.lastIndexOf(".")+1);
        System.out.printf(filename);
        System.out.printf(extension);

        filename=UUID.randomUUID()+"."+extension;
        try {
            Files.copy(file.getInputStream(), Paths.get((SERVER_PATH+folder), filename));
        }catch (IOException e){

        }
        return folder + filename;
    }

    @Override
    public List<String> multipleFileUpload(List<MultipartFile> files, String folder) {
        List<String> filename=new ArrayList<>();
        files.forEach(file -> {
            filename.add(this.singleFileUploadFile(file,folder));
        });
        return filename;
    }

    @Override
    public String upload(MultipartFile file, String folder) {
        return this.singleFileUploadFile(file,folder);
    }

    @Override
    public List<String> upload(List<MultipartFile> files, String folder) {
        return this.multipleFileUpload(files,folder);
    }

    @Override
    public List<String> upload(List<MultipartFile> files) {
        return this.multipleFileUpload(files,null);
    }

    @Override
    public String upload(MultipartFile file) {
        return this.singleFileUploadFile(file,null);
    }
}
