package com.todo.app.myfirstwebapplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {
	private TodoRepository todoRepository;
	
	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoRepository=todoRepository;
	}

	

	@RequestMapping("/list-todo")
	public String ListAllTodos(ModelMap model) {
		String username=(String) getLoggedInUsername(model);
		List<Todo> todos =todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodos";
	}

	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=(String)getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addNewTodoPage( ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username =(String)getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
	//	todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todo";
	}
	
	@RequestMapping("/delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todo";
	}
	int updateid=-1;
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		updateid=id;
		Todo todo=todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodoPage( ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username =(String)getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todo";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication=
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
