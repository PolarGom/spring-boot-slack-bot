package com.example.demo.user.service;

import com.example.demo.common.dto.response.ResponseBody;
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

    /**
     * 사용자 수정
     * 
     * @param userSeq 사용자 키
     * @param requestUser 사용자 정보
     * @throws CommonException
     */
    void updateUser(Integer userSeq, RequestUser requestUser) throws CommonException;

    ResponseBody findAllByUser() throws CommonException;
}
