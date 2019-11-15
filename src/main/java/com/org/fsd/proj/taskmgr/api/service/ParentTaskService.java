package com.org.fsd.proj.taskmgr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.fsd.proj.taskmgr.api.dao.ParentTaskDao;
import com.org.fsd.proj.taskmgr.api.entity.ParentTask;

@Service
public class ParentTaskService {

	@Autowired
	private ParentTaskDao parentTaskDao;

	public List<ParentTask> findAllParentTasks() {
		return (List<ParentTask>) parentTaskDao.findAll();
	}

	public ParentTask saveParentTask(ParentTask parentTask) {
		return parentTaskDao.save(parentTask);
	}

	public void deleteParentTask(int parenttask_id) {
		parentTaskDao.deleteById(parenttask_id);
	}

	public Optional<ParentTask> findByParentTaskID(int parenttask_id) {
		return parentTaskDao.findById(parenttask_id);
	}
}
