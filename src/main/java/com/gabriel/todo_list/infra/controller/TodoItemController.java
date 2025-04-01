package com.gabriel.todo_list.infra.controller;

import com.gabriel.todo_list.application.interfaces.ITodoItemUseCase;
import com.gabriel.todo_list.application.records.CreateTodoItemRecord;
import com.gabriel.todo_list.application.records.TodoItemRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoItemController {

    private final ITodoItemUseCase todoItemUseCase;

    public TodoItemController(ITodoItemUseCase todoItemUseCase)
    {
        this.todoItemUseCase = todoItemUseCase;
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoItemRecord> createTodoItem(@RequestBody CreateTodoItemRecord input)
    {
        var response = todoItemUseCase.createTodoItem(input);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoItemRecord> updateContentTodoItem(@PathVariable int id, @RequestBody CreateTodoItemRecord input)
    {
        var response = todoItemUseCase.updateContentTodoItem(id, input);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/todos/{id}/update-status")
    public ResponseEntity<TodoItemRecord> updateStatus(@PathVariable int id)
    {
        var response = todoItemUseCase.updateStatus(id);
        return ResponseEntity.ok(response);
    }
}
