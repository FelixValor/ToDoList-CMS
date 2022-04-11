package todolist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.app.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	

}
