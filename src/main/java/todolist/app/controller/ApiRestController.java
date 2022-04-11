package todolist.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todolist.app.entity.Task;
import todolist.app.entity.Usuario;
import todolist.app.repository.TaskRepository;
import todolist.app.repository.UserRepository;
import todolist.app.service.TaskService;

@RestController
@RequestMapping(path = "/api")
public class ApiRestController {

	@Autowired
	TaskService service;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/task/listar")
	public ArrayList<Task> getTasks(){
		return (ArrayList<Task>) taskRepository.findAll();
		
	}
	
	@GetMapping("/user/listar")
	public ArrayList<Usuario> getUsuarios(){

		return (ArrayList<Usuario>) userRepository.findAll();
		
	}
	
	@PostMapping("/user/recibir")
	public ResponseEntity<Usuario> recieveUser(@RequestBody Usuario u){
		System.out.println("algo llega");
		Usuario user=userRepository.save(u);
		return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
	}
	
	@PostMapping("/task/recibir")
	public ResponseEntity<Task> recieveTasks(@RequestBody Task t){
		System.out.println("algo llega");
		Task task=taskRepository.save(t);
		return new ResponseEntity<Task>(task,HttpStatus.CREATED);
	}
	
	@PutMapping("/task/recibir")
	public ResponseEntity<Task> modifyTasks(@RequestBody Task t){
		System.out.println("algo llega modificado");
		
		Task task=taskRepository.save(t);
		System.out.println(task.isStatus());
		return new ResponseEntity<Task>(task,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/task/recibir/{id_task}")
	public ResponseEntity<Long> deleteTasks(@PathVariable("id_task") Long id_task){
		System.out.println("algo llega para borrar");
		taskRepository.deleteById(id_task);
		return new ResponseEntity<Long>(id_task,HttpStatus.CREATED);
	}

}
