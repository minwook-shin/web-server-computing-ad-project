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
class UserController(private val userService: UserService) {
    @GetMapping("/signup")
    fun signupForm(@ModelAttribute user: User): String {
        return "signup"
    }

    @PostMapping("/signup")
    fun signup(@ModelAttribute user: User) {
        userService.saveUser(user)
    }

    @GetMapping("/logout")
    fun logout(request: HttpServletRequest, response: HttpServletResponse): String {
        SecurityContextHolder.clearContext()
        HttpSessionSecurityContextRepository().saveContext(SecurityContextHolder.getContext(), request, response)
        return "redirect:/login"
    }

    @GetMapping("/")
    fun index(): String {
        return "redirect:/questions"
    }
}
