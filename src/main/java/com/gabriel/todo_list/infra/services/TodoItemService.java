package com.gabriel.todo_list.infra.services;

import com.gabriel.todo_list.domain.entities.TodoItemEntity;
import com.gabriel.todo_list.domain.mappers.TodoItemMapper;
import com.gabriel.todo_list.infra.repository.TodoItemRepository;

import java.util.Optional;


public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository)
    {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItemEntity CreateTodoItem (TodoItemEntity newTodoItem)
    {
        var todoItem = TodoItemMapper.toModel(newTodoItem);
        var createdItem = todoItemRepository.save(todoItem);
        return TodoItemMapper.toEntity(createdItem);
    }

    public Optional<TodoItemEntity> getTodoItemById(int id)
    {
        var todoItem = todoItemRepository.findById(id);
        return todoItem.map(TodoItemMapper::toEntity);
    }

    public TodoItemEntity updateTodoItem(TodoItemEntity todoItem)
    {
        var todoItemModel = TodoItemMapper.toModel(todoItem);
        var updatedItem = todoItemRepository.save(todoItemModel);
        return TodoItemMapper.toEntity(updatedItem);
    }

}
