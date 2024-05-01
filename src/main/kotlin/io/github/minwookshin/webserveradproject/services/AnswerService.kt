package io.github.minwookshin.webserveradproject.services

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.repositories.AnswerRepository
import org.springframework.stereotype.Service

@Service
class AnswerService(private val answerRepository: AnswerRepository) {
    fun getAnswers() = answerRepository.findAll()
    fun getAnswer(id: Long) = answerRepository.findById(id)
    fun saveAnswer(answer: Answer) = answerRepository.save(answer)
}