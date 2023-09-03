package com.shishkin.todoapp.model

import java.time.LocalDateTime

data class Todo(
    val id: Int,
    val text: String,
    val completed: Boolean,
    val dateCreated: LocalDateTime,
    var dateCompleted: LocalDateTime,
    var dateUpdated: LocalDateTime
)
