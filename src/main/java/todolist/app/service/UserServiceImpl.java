package todolist.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todolist.app.entity.Usuario;
import todolist.app.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired 
	UserRepository userRepository;
	
	
	
	@Override
	public List<Usuario> getAllUsers() {
		
		return null;
	}

	@Override
	public Usuario findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}
	
	

}
