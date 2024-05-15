package io.github.minwookshin.webserveradproject.services

import io.github.minwookshin.webserveradproject.entities.User
import io.github.minwookshin.webserveradproject.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * UserDetailsService 구현 서비스 클래스
 */
@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) : UserDetailsService {

    /**
     * 사용자를 데이터베이스에 저장
     */
    fun saveUser(user: User) {
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }

    /**
     * 사용자 이름으로 사용자 정보를 로드
     *
     * @return UserDetails 인스턴스
     */
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException(username)
        return org.springframework.security.core.userdetails.User(user.username, user.password, emptyList())
    }
}