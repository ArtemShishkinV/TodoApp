package com.shishkin.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shishkin.todoapp.mapper.TodoMapper
import com.shishkin.todoapp.model.Todo
import com.shishkin.todoapp.repo.DefaultTodoRepository
import com.shishkin.todoapp.rest.TodoRestClient
import com.shishkin.todoapp.service.DefaultTodoService
import kotlinx.coroutines.runBlocking
import java.util.logging.Logger
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val logger = Logger.getLogger("MyLogger")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = DefaultTodoService(
            TodoRestClient(),
            TodoMapper(),
            DefaultTodoRepository(listOf<Todo>().toMutableList())
        )

        service.initTodo()
        logger.info(service.getAll().toString())
    }
}