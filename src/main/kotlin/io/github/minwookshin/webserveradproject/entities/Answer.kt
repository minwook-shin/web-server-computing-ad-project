package io.github.minwookshin.webserveradproject.entities

import com.fasterxml.jackson.annotation.JsonBackReference

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn

@Entity
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val content: String = "",
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    val question: Question? = null
)