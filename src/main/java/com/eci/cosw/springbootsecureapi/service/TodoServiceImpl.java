package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    List<Todo> list = new ArrayList<>();

    @Override
    public List<Todo> getTodoList() {
        return list;
    }

    // Seguire la firma dada en el enunciado del lab: donde retornan en el addTodo
    @Override
    public Todo addTodo(Todo todo) {
        list.add(todo);
        return todo;
    }
}
