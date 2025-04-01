package com.gabriel.todo_list.domain.mappers;

import com.gabriel.todo_list.domain.entities.TodoItemEntity;
import com.gabriel.todo_list.infra.model.TodoItemModel;

public class TodoItemMapper {

    public static TodoItemEntity toEntity(TodoItemModel todoItemModel)
    {
        return new TodoItemEntity(todoItemModel.getId(), todoItemModel.getName(),
                todoItemModel.getDescription(), todoItemModel.getStatus());
    }

    public static TodoItemModel toModel(TodoItemEntity todoItemEntity)
    {
        var todoItemModel = new TodoItemModel();
        todoItemModel.setId(todoItemEntity.getId());
        todoItemModel.setName(todoItemEntity.getName());
        todoItemModel.setDescription(todoItemEntity.getDescription());
        todoItemModel.setStatus(todoItemEntity.getStatus());
        return todoItemModel;
    }
}
