package com.shishkin.todoapp.mapper

interface Mapper<SRC, DST> {
    fun transform(data: SRC): DST
}