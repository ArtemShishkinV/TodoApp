package com.shishkin.todoapp.model

import java.time.LocalDate

data class TodoCreateDto(
    val text: String,
    val deadline: LocalDate,
    val priority: TodoPriority
)
