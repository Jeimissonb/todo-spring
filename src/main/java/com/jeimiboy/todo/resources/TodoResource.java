package com.jeimiboy.todo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeimiboy.todo.domain.Todo;
import com.jeimiboy.todo.services.TodoService;

@RestController
@RequestMapping (value = "/todos")
public class TodoResource {
	
	@Autowired
	private TodoService service;
	
	@GetMapping (value = "/{id}")
	public ResponseEntity findById(@PathVariable Integer id){
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping (value = "/open")
	public ResponseEntity<List<Todo>> listOpen (){
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping (value = "/close")
	public ResponseEntity<List<Todo>> listClose(){
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}

}
