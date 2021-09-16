package com.example.demo.user.controller;

import com.example.demo.user.dto.request.RequestUser;
import com.example.demo.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 사용자 컨트롤러
 *
 * @author Demo
 * @since 2021-09-15
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    /**
     * 사용자 등록
     *
     * @param requestUser 사용자 정보
     * @return result 사용자 아이디
     */
    @PostMapping(value = "/user/join")
    public ResponseEntity<String> joinUser(@Valid RequestUser requestUser) {

        log.info("사용자 등록 정보: {}", requestUser.toString());

        userServiceImpl.joinUser(requestUser);

        return ResponseEntity.ok(requestUser.getId());
    }

    /**
     * 사용자 수정
     *
     * @param userSeq 사용자 키
     * @param requestUser 사용자 정보
     * @return result 사용자 아이디
     */
    @PostMapping(value = "/user/{userSeq}")
    public ResponseEntity<String> joinUser(@PathVariable Integer userSeq, @Valid RequestUser requestUser) {

        log.info("{} 키 사용자 수정 정보: {}", userSeq, requestUser.toString());

        userServiceImpl.updateUser(userSeq, requestUser);

        return ResponseEntity.ok(requestUser.getId());
    }
}
