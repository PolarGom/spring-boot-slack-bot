package com.example.demo.user.dto.request;

import com.example.demo.common.exception.CommonException;
import com.example.demo.user.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * 사용자 요청 정보
 *
 * @author Demo
 * @since 2021-09-15
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestUser {

    @NotBlank(message = "아이디를 입력해 주세요.")
    @Size(min = 5, max = 50, message = "아이디는 5 ~ 50자리 사이 입니다.")
    private String id;

    private MultipartFile profileImgFile;

    private String profileImageName;

    public void upload() {
        Optional.ofNullable(profileImgFile).ifPresent(multipartFile -> {
            try {
                profileImageName = String.format("%s_%s", UUID.randomUUID(), multipartFile.getOriginalFilename());

                multipartFile.transferTo(new File(profileImageName));
            } catch ( IOException e ) {

                throw new CommonException(e, "사용자 프로필 이미지 업로드 중 오류가 발생하였습니다.");
            }
        });
    }

    public User toEntity() {

        return User.builder()
                .id(this.id)
                .profileImg(this.profileImageName)
                .build();
    }
}
