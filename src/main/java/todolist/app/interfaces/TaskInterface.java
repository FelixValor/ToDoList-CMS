package todolist.app.interfaces;

import java.util.List;
import java.util.Map;

import todolist.app.entity.Task;

public interface TaskInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listar(int id);
	public Task add(Task t);
	public Task edit(Task t);
	public void delete(int id);
	
	
}
