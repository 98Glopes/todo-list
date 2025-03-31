package com.gabriel.todo_list.infra.controller;

import com.gabriel.todo_list.application.CreateTodoItemUseCase;
import com.gabriel.todo_list.application.interfaces.ICreateTodoItemUseCase;
import com.gabriel.todo_list.application.records.CreateTodoItemRecord;
import com.gabriel.todo_list.application.records.TodoItemRecord;
import com.gabriel.todo_list.infra.repository.TodoItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoItemController {

    private final ICreateTodoItemUseCase createTodoItemUseCase;

    public TodoItemController(ICreateTodoItemUseCase createTodoItemUseCase)
    {
        this.createTodoItemUseCase = createTodoItemUseCase;
    }

    @PostMapping("/todos")
    public TodoItemRecord createTodoItem(@RequestBody CreateTodoItemRecord input)
    {
        return createTodoItemUseCase.execute(input);
    }
}
