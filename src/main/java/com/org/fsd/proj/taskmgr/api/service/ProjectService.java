package com.org.fsd.proj.taskmgr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.fsd.proj.taskmgr.api.dao.ProjectDao;
import com.org.fsd.proj.taskmgr.api.entity.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	public List<Project> findAllProjects()
	{
		return (List<Project>) projectDao.findAll();
	}

	public Project saveProject(Project project)
	{
		return projectDao.save(project);
	}
	
	public void deleteProject(int project_id)
	{
		projectDao.deleteById(project_id);
	}
	
	public Optional<Project> findByProjectID(int project_id)
	{
	    return projectDao.findById(project_id);
	}
}
