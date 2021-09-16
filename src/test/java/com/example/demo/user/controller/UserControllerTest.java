package com.example.demo.user.controller;

import com.example.demo.CommonControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 사용자 컨트롤러 테스트
 *
 * @author Demo
 * @since 2021-09-15
 */
public class UserControllerTest extends CommonControllerTest {

    @Test
    @DisplayName("사용자 등록 테스트")
    public void testJoinUser() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        FileInputStream profileImgFis = null;

        try {

            profileImgFis = new FileInputStream(classLoader.getResource("profile_image.jpeg").getFile());
            MockMultipartFile profileImgFile = new MockMultipartFile("profileImgFile", "profile_image.jpeg", "multipart/from-data", profileImgFis);

            String id = "hahaha";

            this.mockMvc.perform(multipart("/api/v1/user/join")
                    .file(profileImgFile)
                    .param("id", id))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        } catch ( Exception e ) {

            throw e;
        } finally {

            profileImgFis.close();
        }
    }

    @Test
    @DisplayName("사용자 수정 테스트")
    public void testUpdateUser() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        FileInputStream profileImgFis = null;

        try {

            profileImgFis = new FileInputStream(classLoader.getResource("profile_image.jpeg").getFile());
            MockMultipartFile profileImgFile = new MockMultipartFile("profileImgFile", "profile_image.jpeg", "multipart/from-data", profileImgFis);

            Integer userSeq = 1;

            this.mockMvc.perform(multipart("/api/v1/user/{0}", userSeq)
                            .file(profileImgFile))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        } catch ( Exception e ) {

            throw e;
        } finally {

            profileImgFis.close();
        }
    }
}
