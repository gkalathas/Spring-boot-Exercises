package com.example.todoApp.controller;


import com.example.todoApp.model.TodoItem;
import com.example.todoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/all")
    public List<TodoItem> findAll(){
        return todoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<TodoItem> findById(@PathVariable("id") String id){
        return todoRepository.findById(id);
    }

    @PostMapping(value = "/new")
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
       return todoRepository.save(todoItem);
    }

    @PutMapping(value = "/update")
    public Optional<TodoItem> update(@Valid @NotNull @RequestBody TodoItem item) {
        boolean value = true;
        Optional<TodoItem> updatedItem = todoRepository.findById(item.getId());
        updatedItem.get().setDone(value);
        return updatedItem;

    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        todoRepository.deleteById(id);
    }

}
