package com.org.fsd.proj.taskmgr.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.org.fsd.proj.taskmgr.api.entity.Project;

public interface ProjectDao extends CrudRepository<Project, Integer>{

}
