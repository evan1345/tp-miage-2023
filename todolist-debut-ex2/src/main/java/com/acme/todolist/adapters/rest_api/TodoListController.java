package com.acme.todolist.adapters.rest_api;

import java.net.URI;
import org.springframework.http.HttpStatus;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.application.service.AddTodoItemService;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItemService serviceTodoItem ;
	
	
	
	
	@Inject
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItemService serviceTodoItems) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.serviceTodoItem=serviceTodoItems;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	@PostMapping("/createItem")
	@ResponseStatus(HttpStatus.CREATED)
	public void ajouterItem(@RequestBody TodoItem item) {
		
		this.serviceTodoItem.addTodoItem(item);
	}
	
	
	
}
