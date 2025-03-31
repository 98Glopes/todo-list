package com.gabriel.todo_list.application.interfaces;

import com.gabriel.todo_list.application.records.CreateTodoItemRecord;
import com.gabriel.todo_list.application.records.TodoItemRecord;
import org.springframework.context.annotation.Bean;

public interface ICreateTodoItemUseCase {
    TodoItemRecord execute(CreateTodoItemRecord input);
}
