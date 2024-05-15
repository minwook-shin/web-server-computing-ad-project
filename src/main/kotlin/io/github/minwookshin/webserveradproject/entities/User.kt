package io.github.minwookshin.webserveradproject.entities


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
/**
 * 사용자 정보 엔티티 클래스
 */
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var username: String = "",
    var password: String = ""
)