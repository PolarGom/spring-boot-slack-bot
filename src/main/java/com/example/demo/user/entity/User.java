package com.example.demo.user.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 사용자 엔티티
 *
 * @author Demo
 * @since 2021-09-15
 */
@Entity
@Table(name = "USER")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column
    private String id;

    @Column(name = "profile_img")
    private String profileImg;
}
