package todolist.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import todolist.app.entity.Task;
import todolist.app.entity.Usuario;
import todolist.app.repository.TaskRepository;
import todolist.app.repository.UserRepository;

@Controller
public class CMSController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		return "login";
	}
	@GetMapping("/logout")
	public String logout(Model model) {
		
		return "redirect:/login";
	}
	@GetMapping("/")
	public String redirectIndex(Model model) {
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String showIndex(Model model,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		
		List<Usuario> usersList=userRepository.findAll();
		int numUsers=usersList.size();
		model.addAttribute("numUsers", numUsers);
		
		List<Task> taskList=taskRepository.findAll();
		int numTask=taskList.size();
		model.addAttribute("numTask", numTask);
		return "index";
	}
	@GetMapping("/users")
	public String showUsers(Model model,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
	@GetMapping("/newUser")
	public String showNewUser(Model model,@ModelAttribute("user")Usuario user,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		
		model.addAttribute(user);
		return "newUser";
	}
	
	@PostMapping("/newUser")
	public String addNewUser(Model model,@ModelAttribute("user")Usuario user,@RequestParam(name="username")String username,
			@RequestParam(name="email")String email,@RequestParam(name="password")String password) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/tasks")
	public String showTask(Model model,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		
		model.addAttribute("task", taskRepository.findAll());
		return "tasks";
	}
	@GetMapping("/newTask")
	public String showNewTask(Model model,@ModelAttribute("task")Task task,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		
		model.addAttribute(task);
		return "newTask";
	}
	
	@PostMapping("/newTask")
	public String addNewTask(Model model,@ModelAttribute("task")Task task,@RequestParam(name="fk")long fk,
			@RequestParam(name="description") String description, @RequestParam(name="status") boolean status,
			@RequestParam(name = "title")String title) {
		
		Usuario u=new Usuario(fk,"","","");
		
		task.setFk(u);
		taskRepository.save(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/modifyUser")
	public String showModifyUser(Model model,@RequestParam("id")long id,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		Usuario user=userRepository.findById(id).orElse(null);
		model.addAttribute("user",user);
		return "modifyUser";
	}
	
	@PostMapping("/modifyUser")
	public String addModifyUser(Model model,@ModelAttribute("userForm")Usuario user,@RequestParam("id_user")long id,@RequestParam(name="username")String username,
			@RequestParam(name="email")String email,@RequestParam(name="password")String password) {
		
		user.setId_user(id);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEmail(email);
		
		
		userRepository.save(user);
		return "redirect:/users";
	}
	@GetMapping("/modifyTask")
	public String showModifyTask(Model model,@RequestParam("id")long id,Authentication auth) {
		String username=auth.getName();
		model.addAttribute("username", username);
		Task task=taskRepository.findById(id).orElse(null);
		model.addAttribute("task",task);
		return "modifyTask";
	}
	
	@PostMapping("/modifyTask")
	public String addModifyTask(Model model,@ModelAttribute("task")Task task,@RequestParam("id_user")long id,@RequestParam(name="fk")long fk,
			@RequestParam(name="description") String description, @RequestParam(name="status") boolean status,
			@RequestParam(name = "title")String title) {
		
		Usuario u=new Usuario(fk,"","","");
		task.setFk(u);
		task.setId_task(id);
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		
		System.out.println(id);
		
		taskRepository.save(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Model model,@RequestParam("id")long id) {
		Usuario u=userRepository.findById(id).orElse(null);
		userRepository.delete(u);
		return "redirect:/users";
	}
	
	@GetMapping("/deleteTask")
	public String deleteTask(Model model,@RequestParam("id")long id) {
		Task t=taskRepository.findById(id).orElse(null);
		taskRepository.delete(t);
		return "redirect:/tasks";
	}
}
