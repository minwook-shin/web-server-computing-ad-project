package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.User
import io.github.minwookshin.webserveradproject.services.UserService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
/**
 * 사용자 컨트롤러 클래스
 */
class UserController(private val userService: UserService) {
    /**
     * 회원가입 폼을 반환하는 메소드
     *
     * @return 회원가입 폼의 뷰 이름
     */
    @GetMapping("/signup")
    fun signupForm(@ModelAttribute user: User): String {
        return "signup"
    }

    /**
     * 회원가입 요청을 처리하는 메소드
     */
    @PostMapping("/signup")
    fun signup(@ModelAttribute user: User) {
        userService.saveUser(user)
    }

    /**
     * 로그아웃 요청을 처리하는 메소드
     *
     * @return 로그인 페이지로 리다이렉트하는 뷰 이름
     */
    @GetMapping("/logout")
    fun logout(request: HttpServletRequest, response: HttpServletResponse): String {
        SecurityContextHolder.clearContext()
        HttpSessionSecurityContextRepository().saveContext(SecurityContextHolder.getContext(), request, response)
        return "redirect:/login"
    }

    /**
     * 루트 URL 요청을 처리하는 메소드
     *
     * @return 질문 목록 페이지로 리다이렉트하는 뷰 이름
     */
    @GetMapping("/")
    fun index(): String {
        return "redirect:/questions"
    }
}
