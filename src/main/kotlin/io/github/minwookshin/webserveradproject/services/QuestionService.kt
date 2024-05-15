package io.github.minwookshin.webserveradproject.services

import io.github.minwookshin.webserveradproject.entities.Question
import io.github.minwookshin.webserveradproject.repositories.QuestionRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
/**
 * 질문 서비스 클래스
 *
 * @property questionRepository 질문 데이터베이스 인스턴스
 */
class QuestionService(private val questionRepository: QuestionRepository) {
    /**
     * 주어진 ID에 해당하는 질문을 데이터베이스에서 찾아 반환
     *
     * @return ID에 해당하는 질문
     */
    fun getQuestion(id: Long) = questionRepository.findById(id)

    /**
     * 주어진 질문을 데이터베이스에 저장
     *
     * @return 저장된 질문
     */
    fun saveQuestion(question: Question) = questionRepository.save(question)

    /**
     * 페이지네이션으로 질문 목록을 데이터베이스에서 사용
     *
     * @return 페이지네이션된 질문 목록
     */
    fun getQuestionsPage(pageable: Pageable): Page<Question> = questionRepository.findAll(pageable)
}