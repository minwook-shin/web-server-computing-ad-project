package io.github.minwookshin.webserveradproject.entities

import com.fasterxml.jackson.annotation.JsonBackReference

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn

@Entity
/**
 * 답변 엔티티 클래스
 *
 * @property question Question 엔티티와 다대일 관계
 */
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val content: String = "",
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    var question: Question? = null
)