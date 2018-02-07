package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodoList();
    // Seguire la firma dada en el enunciado del lab: donde retornan en el addTodo
    Todo addTodo( Todo todo );
}
