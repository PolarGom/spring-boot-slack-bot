package com.example.demo.user.infra;

import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 사용자 리포지터리
 *
 * @author Demo
 * @since 2021-09-15
 * @see {@link JpaRepository}
 */
public interface IUserRepository extends JpaRepository<User, Integer> {

    /**
     * 사용자 아이디 갯수 조회
     * 
     * @param id 사용자 아이디
     * @return result 아이디 갯수
     */
    int countByIdEquals(String id);
}
