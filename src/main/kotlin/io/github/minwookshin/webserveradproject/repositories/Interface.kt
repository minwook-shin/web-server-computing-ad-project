package io.github.minwookshin.webserveradproject.repositories

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.entities.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Question 엔티티에 대한 CRUD 작업 준비
 */
interface QuestionRepository : JpaRepository<Question, Long>

/**
 * Answer 엔티티에 대한 CRUD 작업 준비
 */
interface AnswerRepository : JpaRepository<Answer, Long>

/**
 * User 엔티티에 대한 CRUD 작업 준비
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}