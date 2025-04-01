package com.gabriel.todo_list.application;

import com.gabriel.todo_list.application.interfaces.ITodoItemUseCase;
import com.gabriel.todo_list.application.records.CreateTodoItemRecord;
import com.gabriel.todo_list.application.records.TodoItemRecord;
import com.gabriel.todo_list.domain.entities.TodoItemEntity;
import com.gabriel.todo_list.infra.services.TodoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoItemUseCase implements ITodoItemUseCase {
    private final TodoItemService todoItemService;

    public TodoItemUseCase(TodoItemService todoItemService)
    {
        this.todoItemService = todoItemService;
    }

    public TodoItemRecord createTodoItem(CreateTodoItemRecord input) {

        var todoItem = new TodoItemEntity(input.name(), input.description());
        var newTodoItem = todoItemService.CreateTodoItem(todoItem);
        return newTodoItem.toRecord();
    }

    public TodoItemRecord updateContentTodoItem(int id, CreateTodoItemRecord input)
    {
        var todoItem = todoItemService.getTodoItemById(id);
        if (todoItem.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        todoItem.get().updateContent(input.name(), input.description());
        return todoItemService.updateTodoItem(todoItem.get()).toRecord();
    }

    public TodoItemRecord updateStatus(int id)
    {
        var todoItem = todoItemService.getTodoItemById(id);
        if (todoItem.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        todoItem.get().updateStatus();
        return todoItemService.updateTodoItem(todoItem.get()).toRecord();
    }
}
