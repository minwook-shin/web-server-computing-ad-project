package io.github.minwookshin.webserveradproject.repositories

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.entities.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long>
interface AnswerRepository : JpaRepository<Answer, Long>