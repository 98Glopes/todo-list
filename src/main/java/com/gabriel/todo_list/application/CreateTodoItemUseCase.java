package com.gabriel.todo_list.application;

import com.gabriel.todo_list.application.interfaces.ICreateTodoItemUseCase;
import com.gabriel.todo_list.application.records.CreateTodoItemRecord;
import com.gabriel.todo_list.application.records.TodoItemRecord;
import com.gabriel.todo_list.domain.entities.TodoItemEntity;
import com.gabriel.todo_list.infra.gateway.TodoItemGateway;

public class CreateTodoItemUseCase implements ICreateTodoItemUseCase {
    private final TodoItemGateway todoItemGateway;

    public CreateTodoItemUseCase(TodoItemGateway todoItemGateway)
    {
        this.todoItemGateway = todoItemGateway;
    }

    public TodoItemRecord execute(CreateTodoItemRecord input) {

        var todoItem = new TodoItemEntity(input.name(), input.description());
        var newTodoItem = todoItemGateway.CreateTodoItem(todoItem);
        return new TodoItemRecord(newTodoItem.getId(), newTodoItem.getName(),
                newTodoItem.getDescription(), newTodoItem.getStatus());
    }
}
