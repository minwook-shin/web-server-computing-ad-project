package io.github.minwookshin.webserveradproject.controllers

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.services.AnswerService
import io.github.minwookshin.webserveradproject.services.QuestionService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/answers")
/**
 * 답변 컨트롤러 클래스
 */
class AnswerController(private val answerService: AnswerService, private val questionService: QuestionService) {
    /**
     * 모든 답변을 반환하는 메소드
     *
     * @return 모든 답변의 리스트
     */
    @GetMapping
    fun listAnswers() = answerService.getAnswers()

    /**
     * 특정 답변의 상세 정보를 반환하는 메소드
     *
     * @return 특정 답변의 상세 정보
     */
    @GetMapping("/{id}")
    fun detailAnswer(@PathVariable id: Long) = answerService.getAnswer(id)

    /**
     * 새 답변을 생성하는 요청을 처리하는 메소드
     *
     * @return 질문 상세 정보 뷰로 리다이렉트
     */
    @PostMapping
    fun createAnswer(@ModelAttribute answer: Answer, @RequestParam question_id: Long): String {
        val question = questionService.getQuestion(question_id).orElseThrow()
        answer.question = question
        answerService.saveAnswer(answer)
        return "redirect:/questions/${question_id}"
    }}