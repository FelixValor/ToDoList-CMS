package todolist.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todolist.app.daomodel.TaskDAO;
import todolist.app.entity.Task;
import todolist.app.interfaces.TaskInterface;

@Service
public class TaskService implements TaskInterface{
	@Autowired
	TaskDAO dao;
	
	@Override
	public List<Map<String, Object>> listar() {
		
		return dao.listar();
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
