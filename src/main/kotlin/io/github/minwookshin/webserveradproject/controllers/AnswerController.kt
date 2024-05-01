package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.services.AnswerService
import io.github.minwookshin.webserveradproject.services.QuestionService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/answers")
class AnswerController(private val answerService: AnswerService, private val questionService: QuestionService) {
    @GetMapping
    fun listAnswers() = answerService.getAnswers()

    @GetMapping("/{id}")
    fun detailAnswer(@PathVariable id: Long) = answerService.getAnswer(id)

    @PostMapping
    fun createAnswer(@ModelAttribute answer: Answer, @RequestParam question_id: Long): String {
        val question = questionService.getQuestion(question_id).orElseThrow()
        answer.question = question
        answerService.saveAnswer(answer)
        return "redirect:/questions/${question_id}"
    }}