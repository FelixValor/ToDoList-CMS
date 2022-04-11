package todolist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.app.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
}
