package com.example.demo.user.dto.response;

import com.example.demo.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 사용자 정보 응답
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ResponseUser {

    private int seq;

    private String id;

    private String profileImg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    public static ResponseUser from(User user) {

        return ResponseUser.builder()
                .seq(user.getSeq())
                .id(user.getId())
                .profileImg(Optional.ofNullable(user.getProfileImg()).orElse(""))
                .createDate(user.getCreateDate())
                .updateDate(user.getUpdateDate())
                .build();
    }

    public static List<ResponseUser> listFrom(List<User> userList) {

        return userList.stream()
                .map(ResponseUser::from)
                .collect(Collectors.toList());
    }
}
