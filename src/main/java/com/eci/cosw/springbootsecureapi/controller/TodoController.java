package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Todo;
import com.eci.cosw.springbootsecureapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api" )
public class TodoController {
    @Autowired
    private TodoService ts;

    @CrossOrigin
    @RequestMapping( value = "/todos", method = RequestMethod.GET )
    public List<Todo> getTodoList() {
        return ts.getTodoList();
    }

    // Retorno por que asi es la firma dada en el enunciado del lab
    @CrossOrigin
    @RequestMapping( value = "/todo", method = RequestMethod.POST )
    public Todo addTodo(@RequestBody Todo todo) {
        ts.addTodo(todo);
        return todo;
    }
}
