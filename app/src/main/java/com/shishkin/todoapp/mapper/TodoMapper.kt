package com.shishkin.todoapp.mapper

import com.shishkin.todoapp.model.Todo
import com.shishkin.todoapp.model.TodoPriority
import com.shishkin.todoapp.rest.TodoDto
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

class TodoMapper : Mapper<TodoDto, Todo> {

    private val random = ThreadLocalRandom.current()
    override fun transform(data: TodoDto): Todo {
        val dateCreated = getDateCreated()
        val priorities = TodoPriority.values()
        return Todo(
            id = data.id,
            text = data.title,
            completed = data.completed,
            dateCreated = dateCreated,
            dateCompleted = getDateCompleted(data.completed, dateCreated),
            dateUpdated = dateCreated,
            deadLine = dateCreated.plusDays(random.nextInt(1, 20).toLong()),
            priority = priorities[random.nextInt(0, priorities.size)]
        )
    }

    private fun getDateCreated(): LocalDateTime {
        val year = 2023
        val month = random.nextInt(1, 9)
        val day = random.nextInt(1, 27)
        val hours = random.nextInt(1, 23)

        return LocalDateTime.of(year, month, day, hours, 0)
    }

    //TODO: метод говно надо переписать логику
    private fun getDateCompleted(completed: Boolean, dateCreated: LocalDateTime): LocalDateTime? {
        return if (completed) LocalDateTime.of(
            dateCreated.year,
            random.nextInt(dateCreated.month.value, 8 + 1),
            random.nextInt(dateCreated.dayOfMonth, 27 + 1),
            random.nextInt(dateCreated.hour + 1, 23 + 1),
            0
        ) else null
    }

}