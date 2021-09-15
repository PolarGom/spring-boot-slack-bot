package com.example.demo.user.service;

import com.example.demo.common.exception.CommonException;
import com.example.demo.user.dto.request.RequestUser;

/**
 * 사용자 서비스
 *
 * @author Demo
 * @since 2021-09-15
 */
public interface IUserService {

    /**
     * 사용자 등록
     * 
     * @param requestUser 사용자 정보
     * @throws CommonException
     */
    void joinUser(RequestUser requestUser) throws CommonException;
}
