package com.gabriel.todo_list;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gabriel.todo_list.application.CreateTodoItemUseCase;
import com.gabriel.todo_list.infra.gateway.TodoItemGateway;
import com.gabriel.todo_list.infra.repository.TodoItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    CreateTodoItemUseCase createTodoItemUseCase(TodoItemGateway todoItemGateway)
    {
        return new CreateTodoItemUseCase(todoItemGateway);
    }

    @Bean
    TodoItemGateway todoItemGateway(TodoItemRepository todoItemRepository)
    {
        return new TodoItemGateway(todoItemRepository);
    }
}
