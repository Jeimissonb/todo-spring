package com.jeimiboy.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeimiboy.todo.domain.Todo;
import com.jeimiboy.todo.repositories.TodoRepository;

@Service
public class TodoService {

		@Autowired
		private TodoRepository repository;
		
		public Todo findById (Integer id) {
			Optional <Todo> obj = repository.findById(id);
			return obj.orElse(null);
		}

		public List<Todo> findAllOpen() {
			List <Todo> list = repository.findAllOpen();
			return list;
		}
		
		public List<Todo> findAllClose (){
			List<Todo> list = repository.findAllClose();
			return list;
		}
	
}