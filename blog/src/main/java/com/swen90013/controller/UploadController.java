package com.swen90013.controller;

import com.jerry.domain.ResponseResult;
import com.jerry.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseResult upLoad(MultipartFile img) {
        return uploadService.uploadImage(img);
    }
}
