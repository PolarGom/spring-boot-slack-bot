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
}
