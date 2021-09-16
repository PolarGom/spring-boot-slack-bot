package com.example.demo.common.utils;

import com.example.demo.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 파일 유틸리티
 *
 * @author Demo
 * @since 2021-09-16
 */
@Component
@Slf4j
public class FileUtils {

    @Value("${spring.servlet.multipart.location}")
    private String localTempFilePath;

    /**
     * 로컬 파일 업로드
     *
     * @param multipartFile 업로드 할 파일
     * @return result 파일 이름
     */
    public String upload(MultipartFile multipartFile) {

        try {

            String fileName = String.format("%s_%s", UUID.randomUUID(), multipartFile.getOriginalFilename());

            multipartFile.transferTo(new File(String.format("%s%s", localTempFilePath, fileName)));

            return fileName;
        } catch ( IOException e ) {

            throw new CommonException(e, "파일 업로드 중 오류가 발생하였습니다.");
        }
    }
}
