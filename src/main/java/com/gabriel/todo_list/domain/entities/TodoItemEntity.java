package com.gabriel.todo_list.domain.entities;

public class TodoItemEntity {
    private Integer id;
    private String name;
    private String description;
    private String status;

    public TodoItemEntity (String name, String description)
    {
        setName(name);
        setDescription(description);
        setStatus("created");
    }

    public TodoItemEntity (Integer id, String name, String description, String status)
    {
        setId(id);
        setName(name);
        setDescription(description);
        setStatus(status);
    }

    public Integer getId()
    {
        return this.id;
    }

    private void setId(Integer id)
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

    private void setStatus(String status)
    {
        this.status = status;
    }
}
