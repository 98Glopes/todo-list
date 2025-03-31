package com.gabriel.todo_list.infra.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TodoItems")
public class TodoItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String status;

    public TodoItemModel () {}

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
