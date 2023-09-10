package com.shishkin.todoapp.service

import com.shishkin.todoapp.model.Todo

interface TodoService {
    fun getAll(): List<Todo>
    fun create(todo: Todo): Boolean
    fun update(todo: Todo): Todo
    fun initTodo(): Boolean
}