package com.example.demo.user.entity;

import com.example.demo.common.jpa.TimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Optional;

/**
 * 사용자 엔티티
 *
 * @author Demo
 * @since 2021-09-15
 * @see {@link TimeEntity}
 */
@Entity
@Table(name = "USER")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(name = "id")
    private String id;

    @Column(name = "profile_img")
    private String profileImg;

    public void update(String profileImageName) {

        Optional.ofNullable(profileImageName).ifPresent(s -> this.profileImg = s);
    }
}
