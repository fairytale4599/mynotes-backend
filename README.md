# GET Notes

Getting all notes
``GET http://localhost:8080/api/notes``

```sh
    {
        "id": note_id,
        "note_title": "note_title",
        "note_text": "note_text",
        "created_at": "created_at"
    }
```

# GET Notes (by id)

Getting certain note by id
``GET http://localhost:8080/api/notes/{id}``

```sh
    {
        "id": note_id,
        "note_title": "note_title",
        "note_text": "note_text",
        "created_at": "created_at"
    }
```

# PUT note

Update the note
``PUT http://localhost:8080/api/notes/{id}``

```sh
    {
        "note_title": "note_title",
        "note_text": "note_text",
        "created_at": "created_at"
    }
```

If all goes well:

```Note has been updated.```

# DELETE note

Change the note
``DELETE http://localhost:8080/api/notes/{id}``

If all goes well:

```Note has been deleted.```

# POST note

Post the note
``POST http://localhost:8080/api/notes``

```sh
    {
        "note_title": "note_title",
        "note_text": "note_text",
        "created_at": "created_at"
    }
```

If all goes well:

```sh
    {
        "id": note_id,
        "note_title": "note_title",
        "note_text": "note_text",
        "created_at": "created_at"
    }
```
