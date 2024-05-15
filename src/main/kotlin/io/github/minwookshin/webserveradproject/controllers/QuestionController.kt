package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.services.QuestionService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/questions")
/**
 * 질문 컨트롤러 클래스
 *
 * @property questionService 질문 데이터베이스 인스턴스
 */
class QuestionController(private val questionService: QuestionService) {
    /**
     * 질문 목록을 반환하는 메소드
     *
     * @return 질문 목록 뷰의 이름
     */
    @GetMapping
    fun listQuestions(@RequestParam(defaultValue = "0") page: Int, model: Model): String {
        val pageable = PageRequest.of(page, 5)
        val questionsPage = questionService.getQuestionsPage(pageable)
        model.addAttribute("questionsPage", questionsPage)
        return "questions"
    }

    /**
     * 특정 질문의 상세 정보를 반환하는 메소드
     *
     * @return 질문 상세 정보 뷰의 이름 또는 질문 목록 뷰 리다이렉트
     */
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

    /**
     * 새 질문을 생성하는 폼을 반환하는 메소드
     *
     * @return 새 질문 생성 폼 뷰의 이름
     */
    @GetMapping("/new")
    fun newQuestion(model: Model): String {
        model.addAttribute("question", Question())
        return "new_question"
    }

    /**
     * 새 질문을 생성하는 요청을 처리하는 메소드
     *
     * @return 질문 목록 뷰로 리다이렉트
     */
    @PostMapping
    fun createQuestion(@ModelAttribute question: Question): String {
        questionService.saveQuestion(question)
        return "redirect:/questions"
    }
}