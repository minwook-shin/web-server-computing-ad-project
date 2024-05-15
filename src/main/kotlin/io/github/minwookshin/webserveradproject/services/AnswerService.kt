package io.github.minwookshin.webserveradproject.services

import io.github.minwookshin.webserveradproject.entities.Answer
import io.github.minwookshin.webserveradproject.repositories.AnswerRepository
import org.springframework.stereotype.Service

/**
 * 답변 서비스 클래스
 *
 * @property answerRepository 답변 데이터베이스 인스턴스
 */
@Service
class AnswerService(private val answerRepository: AnswerRepository) {
    /**
     * 모든 답변을 데이터베이스에서 수집
     *
     * @return 모든 답변의 리스트입니다.
     */
    fun getAnswers() = answerRepository.findAll()

    /**
     * 주어진 ID에 해당하는 답변을 데이터베이스에서 찾아 반환
     *
     * @return ID에 해당하는 답변. 없을 경우 null을 반환합니다.
     */
    fun getAnswer(id: Long) = answerRepository.findById(id)

    /**
     * 주어진 답변을 데이터베이스에 저장
     *
     * @return 저장된 답변입니다.
     */
    fun saveAnswer(answer: Answer) = answerRepository.save(answer)
}