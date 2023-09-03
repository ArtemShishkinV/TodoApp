package com.shishkin.todoapp.rest

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.jackson.jackson

class TodoRestClient {
    private val baseURL = "https://jsonplaceholder.typicode.com"
    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            jackson()
        }
        install(Logging) {
            level = LogLevel.INFO
            logger = Logger.DEFAULT
        }
    }

    suspend fun getAll(): List<TodoDto> = httpClient.get("$baseURL/todos").call.body()
}