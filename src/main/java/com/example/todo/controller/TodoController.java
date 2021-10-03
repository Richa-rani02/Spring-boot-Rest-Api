package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.ResourceNotFoundException;
import com.example.todo.model.todo;
import com.example.todo.repository.TodoRepo;

@RestController
@RequestMapping("/")
public class TodoController {
	@Autowired
	TodoRepo todorepo;

	@GetMapping
	public String Start() {
		return "welcome to Todo App";
	}

	@GetMapping("todos")
	public List<todo> getAllNotes() {
		return todorepo.findAll();
	}

	@PostMapping(path = "todos")
	public todo addNotes(@RequestBody todo todo) {

		todorepo.save(todo);
		return todo;
	}

	@GetMapping("/todos/{id}")
	public todo getTodoById(@PathVariable(value = "id") int Id) {
		return todorepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("todo", "id", Id));
	}

	@DeleteMapping("/todos/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") int Id) {
		todo todo = todorepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", Id));

		todorepo.delete(todo);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/todos")
	public todo updatetodo(@RequestBody todo todo) {

		todorepo.save(todo);
		return todo;
	}
}
