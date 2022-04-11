package todolist.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todolist.app.entity.Task;
import todolist.app.entity.Usuario;

@Service
public interface UserService {
	List<Usuario> getAllUsers();
	public Usuario findByUsername(String username);
	
	
}
