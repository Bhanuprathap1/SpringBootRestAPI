package com.org.fsd.proj.taskmgr.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.org.fsd.proj.taskmgr.api.entity.Task;

public interface TaskDao extends CrudRepository<Task, Integer>{

	public static final String FIND_TASKS_BY_PROJECT_ID = "SELECT * FROM task where project_id = ?";

	@Query(value = FIND_TASKS_BY_PROJECT_ID, nativeQuery = true)
	 List<Task> findByProjectId(int project_id);
}
