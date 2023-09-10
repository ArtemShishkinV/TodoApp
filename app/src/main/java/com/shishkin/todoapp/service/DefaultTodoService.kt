package com.shishkin.todoapp.service

import com.shishkin.todoapp.mapper.Mapper
import com.shishkin.todoapp.model.Todo
import com.shishkin.todoapp.repo.TodoRepository
import com.shishkin.todoapp.rest.TodoDto
import com.shishkin.todoapp.rest.TodoRestClient
import kotlinx.coroutines.runBlocking
import java.util.logging.Logger
import kotlin.streams.toList

class DefaultTodoService(
    private val client: TodoRestClient,
    private val mapper: Mapper<TodoDto, Todo>,
    private val repository: TodoRepository
): TodoService {
    private val logger = Logger.getLogger("MyLogger")
    override fun getAll(): List<Todo> {
        return repository.findAll()
    }

    override fun create(todo: Todo): Boolean {
        // TODO("validate fields")
        return repository.create(todo)
    }

    override fun update(todo: Todo): Todo {
        // TODO("validate fields")
        return repository.update(todo)
    }

    override fun initTodo(): Boolean {
        runBlocking {
            val data = client.getAll()
            val mappedData = repository.saveAll(data.stream().map {
                Thread.sleep(500L)
                logger.info(it.toString())
                mapper.transform(it)
            }.toList())
            return@runBlocking mappedData
        }
        return false
    }
}