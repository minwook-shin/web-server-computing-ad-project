package io.github.minwookshin.webserveradproject.repositories

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long>
interface AnswerRepository : JpaRepository<Answer, Long>

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}