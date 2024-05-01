package io.github.minwookshin.webserveradproject.services

import io.github.minwookshin.webserveradproject.entities.User
import io.github.minwookshin.webserveradproject.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) : UserDetailsService {
    fun saveUser(user: User) {
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException(username)
        return org.springframework.security.core.userdetails.User(user.username, user.password, emptyList())
    }
}