package com.shishkin.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shishkin.todoapp.rest.TodoRestClient
import kotlinx.coroutines.runBlocking
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    private val logger = Logger.getLogger("MyLogger")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runBlocking {
            logger.info(TodoRestClient().getAll().toString())
        }
    }
}