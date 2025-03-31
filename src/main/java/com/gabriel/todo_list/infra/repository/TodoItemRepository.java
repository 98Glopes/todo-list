package com.gabriel.todo_list.infra.repository;

import com.gabriel.todo_list.infra.model.TodoItemModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItemModel, Integer> {

}
