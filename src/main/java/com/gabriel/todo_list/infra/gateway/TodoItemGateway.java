package com.gabriel.todo_list.infra.gateway;

import com.gabriel.todo_list.domain.entities.TodoItemEntity;
import com.gabriel.todo_list.infra.model.TodoItemModel;
import com.gabriel.todo_list.infra.repository.TodoItemRepository;


public class TodoItemGateway {

    private final TodoItemRepository todoItemRepository;

    public TodoItemGateway(TodoItemRepository todoItemRepository)
    {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItemEntity CreateTodoItem (TodoItemEntity newTodoItem)
    {
        var todoItem = new TodoItemModel();
        todoItem.setName(newTodoItem.getName());
        todoItem.setDescription(newTodoItem.getDescription());
        todoItem.setStatus(newTodoItem.getStatus());

        var createdItem = todoItemRepository.save(todoItem);

        return new TodoItemEntity(createdItem.getId(), createdItem.getName(),
                createdItem.getDescription(), createdItem.getStatus());
    }
}
