package com.example.demo.config;

import com.example.demo.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 공통 컨트롤러 Advice
 *
 * @author Demo
 * @since 2021-09-14
 */
@RestControllerAdvice
@Slf4j
public class CommonControllerAdvice {

    /**
     * @RequestBody 시 객체 변수에 Setter를 안쓰고 필드 변수명으로 접근
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.initDirectFieldAccess();
    }

    @ExceptionHandler({ CommonException.class })
    public ResponseEntity<String> commonException(CommonException exception) {

        log.error(String.format("Advice: %s", exception.getErrorMsg()), exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getErrorMsg());
    }

    /**
     * requestBody 혹은 requestPart 에 대한 valid 오류 처리 메소드
     *
     * @param exception 익셉션
     * @return result 오류난 정보 반환
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {

        log.error(String.format("Advice: MethodArgumentNotValidException %s", exception.getMessage()), exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getBindingResult().getAllErrors().stream().findFirst()
                        .map(objectError -> objectError.getDefaultMessage()).orElse("[Err01]처리 중 오류가 발생하였습니다."));
    }

    /**
     * ModelAttribute 으로 binding 오류 처리 메소드
     *
     * @param exception 익셉션
     * @return result 오류난 정보 반환
     */
    @ExceptionHandler({BindException.class})
    public ResponseEntity<String> bindExceptionHandler(BindException exception) {

        log.error(String.format("Advice: BindException %s", exception.getMessage()), exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getAllErrors().stream().findFirst()
                        .map(objectError -> objectError.getDefaultMessage()).orElse("[Err02]처리 중 오류가 발생하였습니다."));
    }
}
