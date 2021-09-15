package com.example.demo.info.controller;

import com.example.demo.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 정보 컨트롤러
 *
 * @author Demo
 * @since 2021-09-13
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class InfoController {

    @GetMapping(value = "/v1/info")
    public ResponseEntity<String> info() {

        log.info("GET] info");

        return ResponseEntity.ok("hello");
    }

    @PostMapping(value = "/v1/info/upload")
    public ResponseEntity<String> updateFile(@RequestPart MultipartFile multipartFile) {

        log.info("Post] info File Upload");

        try {

            String fileName = String.format("%s_%s", UUID.randomUUID(), multipartFile.getOriginalFilename());

            multipartFile.transferTo(new File(fileName));

            return ResponseEntity.ok(fileName);
        } catch ( IOException e ) {

            throw new CommonException(e, "파일 업로드 중 오류가 발생하였습니다.");
        }
    }
}
