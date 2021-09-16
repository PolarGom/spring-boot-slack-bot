package com.example.demo.user.service;

import com.example.demo.common.exception.CommonException;
import com.example.demo.common.utils.FileUtils;
import com.example.demo.user.dto.request.RequestUser;
import com.example.demo.user.entity.User;
import com.example.demo.user.infra.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 사용자 서비스 구현체
 *
 * @author Demo
 * @since 2021-09-15
 * @see {@link IUserService}
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private IUserRepository userRepository;

    @Transactional(value = "entityTransactionManager", rollbackFor = { Exception.class, CommonException.class })
    @Override
    public void joinUser(RequestUser requestUser) throws CommonException {

        try {

            requestUser.onVerifyDuplicateId(userRepository.countByIdEquals(requestUser.getId()));
            requestUser.upload(fileUtils);

            userRepository.save(requestUser.toEntity());
        } catch ( CommonException e ) {

            throw e;
        } catch ( Exception e ) {

            throw new CommonException(e, "사용자 등록 중 오류가 발생하였습니다.");
        }
    }

    @Transactional(value = "entityTransactionManager", rollbackFor = { Exception.class, CommonException.class })
    @Override
    public void updateUser(Integer userSeq, RequestUser requestUser) throws CommonException {

        try {

            requestUser.upload(fileUtils);

            User user = userRepository.findById(userSeq).get();
            user.update(requestUser.getProfileImageName());

            userRepository.save(user);
        } catch ( CommonException e ) {

            throw e;
        } catch ( Exception e ) {

            throw new CommonException(e, "사용자 수정 중 오류가 발생하였습니다.");
        }
    }
}
