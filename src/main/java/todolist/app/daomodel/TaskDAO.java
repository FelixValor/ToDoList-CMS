package todolist.app.daomodel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import todolist.app.entity.Task;
import todolist.app.interfaces.TaskInterface;

@Repository
public class TaskDAO implements TaskInterface {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>>lista=template.queryForList("select * from task");
		return lista;
	}

	@Override
	public List<Map<String, Object>> listar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task add(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task edit(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
