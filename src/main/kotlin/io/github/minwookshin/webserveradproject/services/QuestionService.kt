package io.github.minwookshin.webserveradproject.services

import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.repositories.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(private val questionRepository: QuestionRepository) {
    fun getQuestions() = questionRepository.findAll()
    fun getQuestion(id: Long) = questionRepository.findById(id)
    fun saveQuestion(question: Question) = questionRepository.save(question)
}