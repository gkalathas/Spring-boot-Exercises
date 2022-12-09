package com.example.todoApp.repository;

import com.example.todoApp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, String> {


}
