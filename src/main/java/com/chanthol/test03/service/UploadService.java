package com.chanthol.test03.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;
import java.util.List;

public interface UploadService {
    String singleFileUploadFile (MultipartFile file, String folder);

    List<String> multipleFileUpload(List<MultipartFile> files,String folder);

    String upload(MultipartFile file,String folder);
    List<String> upload(List<MultipartFile> files,String folder);

    List<String> upload(List<MultipartFile> files);
    String upload(MultipartFile file);

}
