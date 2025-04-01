package com.gabriel.todo_list.domain.entities;

import com.gabriel.todo_list.application.records.TodoItemRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

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
        if (name.isBlank())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be empty");
        }
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        if (description.isBlank())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Description cannot be empty");
        }
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    private void setStatus(String status)
    {
        this.status = status;
    }

    private boolean isCompleted()
    {
        return getStatus().equals("completed");
    }

    public void updateContent(String name, String description)
    {
        if (isCompleted())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot update completed item");
        }
        if (!name.isBlank())
        {
            setName(name);
        }
        if (!description.isBlank())
        {
            setDescription(description);
        }
    }

    //TODO: Create unite tests to ensure this business rule and refactor this method
    public void updateStatus()
    {
        var nextStatus = new HashMap<String, String>();
        nextStatus.put("created", "in_progress");
        nextStatus.put("in_progress", "completed");
        if (getStatus().equals("completed"))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot update completed item");
        }
        setStatus(nextStatus.get(getStatus()));
    }

    public TodoItemRecord toRecord()
    {
        return new TodoItemRecord(getId(), getName(), getDescription(), getStatus());
    }
}
