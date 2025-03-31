# todo-list

Aplicão de Todo List com os seguintes requisitos:

## Use Case 1:

Create a To-Do Item

Create a new to-do item using the following request:

`POST /todos`
```
{
  "title": "Buy groceries",
  "description": "Buy milk, eggs, and bread"
}
```

must return a json with
```
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Buy milk, eggs, and bread",
  "status": "created"
}
```

# Use Case 2:
Update a To-Do Item

Update an existing to-do item using the following request:

`PUT /todos/1`
```
{
  "title": "Buy groceries",
  "description": "Buy milk, eggs, bread, and cheese"
}
```

If successful, must return a json with
```
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Buy milk, eggs, bread, and cheese",
  "status": "created"
}
```

Could'nt be possible update the status of the todo-item and coud'nt be possible update a todo-item with status "completed".

# Use Case 3
Update To-Do Item status

Implement a status life cycle for To-Do Item, considering the follow status sequence:
`created -> in_progress -> completed`

`POST todos/1/update-status`
```
{
  "new_status": "in_progress"
}
```

Must return a json with
```
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Buy milk, eggs, bread, and cheese",
  "status": "in_progress"
}
```

Could'nt be possible update status from created directly to completed. If the new status isn't accord the lifecycle must return an error
