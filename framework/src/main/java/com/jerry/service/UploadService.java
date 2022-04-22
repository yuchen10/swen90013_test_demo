package com.jerry.service;

import com.jerry.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResult uploadImage(MultipartFile img);
}
