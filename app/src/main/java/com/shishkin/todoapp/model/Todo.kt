package com.shishkin.todoapp.model

import java.time.LocalDateTime

data class Todo(
    val id: Int,
    val text: String,
    val completed: Boolean,
    val deadLine: LocalDateTime,
    val priority: TodoPriority,
    val dateCreated: LocalDateTime,
    var dateCompleted: LocalDateTime?,
    var dateUpdated: LocalDateTime
)
