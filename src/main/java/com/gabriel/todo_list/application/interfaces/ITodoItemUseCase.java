package com.gabriel.todo_list.application.interfaces;

import com.gabriel.todo_list.application.records.CreateTodoItemRecord;
import com.gabriel.todo_list.application.records.TodoItemRecord;

public interface ITodoItemUseCase {
    TodoItemRecord createTodoItem(CreateTodoItemRecord input);
    TodoItemRecord updateContentTodoItem(int id, CreateTodoItemRecord input);
}
