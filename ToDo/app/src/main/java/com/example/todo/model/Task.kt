package com.example.todo.model

data class Task(
    var name: String,
    var description: String,
    var responsible: String,
    var data: String,
    var status: Boolean,
    var category: String
) {
}