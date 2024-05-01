package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.services.QuestionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/questions")
class QuestionController(private val questionService: QuestionService) {
    @GetMapping
    fun listQuestions(model: Model): String {
        val questions = questionService.getQuestions()
        model.addAttribute("questions", questions)
        return "questions"
    }

    @GetMapping("/{id}")
    fun detailQuestion(@PathVariable id: Long, model: Model): String {
        val optionalQuestion = questionService.getQuestion(id)
        if (optionalQuestion.isPresent) {
            model.addAttribute("question", optionalQuestion.get())
        } else {
            return "redirect:/questions"
        }
        return "question_detail"
    }

    @GetMapping("/new")
    fun newQuestion(model: Model): String {
        model.addAttribute("question", Question())
        return "new_question"
    }

    @PostMapping
    fun createQuestion(@ModelAttribute question: Question): String{
        questionService.saveQuestion(question)
        return "redirect:/questions"
    }
}