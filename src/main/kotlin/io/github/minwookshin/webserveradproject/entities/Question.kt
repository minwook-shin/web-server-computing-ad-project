package io.github.minwookshin.webserveradproject.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
data class Question(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var title: String = "",
    var content: String = "",
    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    var answers: List<Answer> = listOf()
)