package com.shishkin.todoapp.repo

import com.shishkin.todoapp.model.Todo

class DefaultTodoRepository(
    private var data: MutableList<Todo>
) : TodoRepository {
    override fun findAll(): MutableList<Todo> {
        return data.toMutableList()
    }

    override fun create(todo: Todo): Boolean {
        return data.add(todo)
    }

    override fun update(todo: Todo): Todo {
        return data.set(todo.id - 1, todo)
    }

    override fun saveAll(inData: List<Todo>): Boolean {
        return data.addAll(inData)
    }
}