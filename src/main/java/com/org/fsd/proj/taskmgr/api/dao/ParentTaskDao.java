package com.org.fsd.proj.taskmgr.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.org.fsd.proj.taskmgr.api.entity.ParentTask;

public interface ParentTaskDao extends CrudRepository<ParentTask, Integer>{

}
