package io.github.minwookshin.webserveradproject.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
/**
 * 로그인 컨트롤러 클래스
 */
class LoginController {
    /**
     * 로그인 페이지를 반환하는 메소드
     *
     * @return 로그인 페이지의 뷰 이름
     */
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }
}