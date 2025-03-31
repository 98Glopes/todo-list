package com.gabriel.todo_list.infra.services;

import com.gabriel.todo_list.domain.entities.TodoItemEntity;
import com.gabriel.todo_list.infra.model.TodoItemModel;
import com.gabriel.todo_list.infra.repository.TodoItemRepository;


public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository)
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

    public TodoItemEntity getTodoItemById(int id)
    {
        var todoItem = todoItemRepository.findById(id);
        return todoItem.map(todoItemModel -> new TodoItemEntity(todoItemModel.getId(), todoItemModel.getName(),
                todoItemModel.getDescription(), todoItemModel.getStatus())).orElse(null);
    }

    public TodoItemEntity updateContent(TodoItemEntity todoItem)
    {
        var todoItemModel = new TodoItemModel();
        todoItemModel.setName(todoItem.getName());
        todoItemModel.setDescription(todoItem.getDescription());
        todoItemModel.setStatus(todoItem.getStatus());
        todoItemModel.setId(todoItem.getId());

        var updatedItem = todoItemRepository.save(todoItemModel);
        return new TodoItemEntity(updatedItem.getId(), updatedItem.getName(),
                updatedItem.getDescription(), updatedItem.getStatus());
    }

}
