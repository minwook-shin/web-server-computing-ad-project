package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.services.QuestionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/questions")
class QuestionController(private val questionService: QuestionService) {
    @GetMapping
    fun listQuestions() = questionService.getQuestions()

    @GetMapping("/{id}")
    fun detailQuestion(@PathVariable id: Long) = questionService.getQuestion(id)

    @PostMapping
    fun createQuestion(@RequestBody question: Question) = questionService.saveQuestion(question)
}