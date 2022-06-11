package com.example.todo.model

 data class Category(
  var id: Long,
  var description: String,
  var task: Task
 ) {
}