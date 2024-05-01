package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.services.AnswerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/answers")
class AnswerController(private val answerService: AnswerService) {
    @GetMapping
    fun listAnswers() = answerService.getAnswers()

    @GetMapping("/{id}")
    fun detailAnswer(@PathVariable id: Long) = answerService.getAnswer(id)

    @PostMapping
    fun createAnswer(@RequestBody answer: Answer) = answerService.saveAnswer(answer)
}