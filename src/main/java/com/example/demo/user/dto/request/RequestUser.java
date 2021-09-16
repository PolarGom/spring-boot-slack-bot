package com.example.demo.user.dto.request;

import com.example.demo.common.utils.FileUtils;
import com.example.demo.user.entity.User;
import com.example.demo.user.exception.DuplicateIdException;
import com.example.demo.user.validation.UserValidationGroup;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

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

    @NotBlank(message = "아이디를 입력해 주세요.", groups = {UserValidationGroup.joinUser.class})
    @Size(min = 5, max = 50, message = "아이디는 5 ~ 50자리 사이 입니다.", groups = {UserValidationGroup.joinUser.class})
    private String id;

    private MultipartFile profileImgFile;

    private String profileImageName;

    public void onVerifyDuplicateId(int duplicateIdCount) {

        if ( duplicateIdCount != 0 ) {

            throw new DuplicateIdException();
        }
    }

    public void upload(FileUtils fileUtils) {

        Optional.ofNullable(profileImgFile).ifPresent(multipartFile -> this.profileImageName = fileUtils.upload(multipartFile));
    }

    public User toEntity() {

        return User.builder()
                .id(this.id)
                .profileImg(this.profileImageName)
                .build();
    }
}
