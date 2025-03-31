package com.gabriel.todo_list;

import com.gabriel.todo_list.application.TodoItemUseCase;
import com.gabriel.todo_list.infra.services.TodoItemService;
import com.gabriel.todo_list.infra.repository.TodoItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    TodoItemUseCase createTodoItemUseCase(TodoItemService todoItemService)
    {
        return new TodoItemUseCase(todoItemService);
    }

    @Bean
    TodoItemService todoItemGateway(TodoItemRepository todoItemRepository)
    {
        return new TodoItemService(todoItemRepository);
    }
}
