package com.shishkin.todoapp.repo

import com.shishkin.todoapp.model.Todo
import com.shishkin.todoapp.rest.TodoDto

interface TodoRepository {
    fun findAll(): MutableList<Todo>
    fun create(todo: Todo): Boolean
    fun update(todo: Todo): Todo
    fun saveAll(data: List<Todo>): Boolean
}