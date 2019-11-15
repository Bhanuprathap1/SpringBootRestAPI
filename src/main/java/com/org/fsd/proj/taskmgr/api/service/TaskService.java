package com.org.fsd.proj.taskmgr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.fsd.proj.taskmgr.api.dao.TaskDao;
import com.org.fsd.proj.taskmgr.api.entity.Task;

@Service
public class TaskService {

	@Autowired
	private TaskDao taskDao;

	public List<Task> findAllTasks() {
		return (List<Task>) taskDao.findAll();
	}

	public Task saveTask(Task task) {
		return taskDao.save(task);
	}

	public void deleteTask(int task_id) {
		taskDao.deleteById(task_id);
	}

	public Optional<Task> findByTaskID(int task_id) {
		return taskDao.findById(task_id);
	}
	
	public List<Task> findByProjectId(int project_id) {
		return taskDao.findByProjectId(project_id);
	}
}
