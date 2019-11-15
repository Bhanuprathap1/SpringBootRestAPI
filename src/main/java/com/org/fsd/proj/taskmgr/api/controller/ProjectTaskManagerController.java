package com.org.fsd.proj.taskmgr.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.fsd.proj.taskmgr.api.entity.ParentTask;
import com.org.fsd.proj.taskmgr.api.entity.Project;
import com.org.fsd.proj.taskmgr.api.entity.Task;
import com.org.fsd.proj.taskmgr.api.entity.Users;
import com.org.fsd.proj.taskmgr.api.service.ParentTaskService;
import com.org.fsd.proj.taskmgr.api.service.ProjectService;
import com.org.fsd.proj.taskmgr.api.service.TaskService;
import com.org.fsd.proj.taskmgr.api.service.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/projtaskmgr")
public class ProjectTaskManagerController {
	
	public static final String ANGULAR_URL = "http://localhost:4200";

	@Autowired
	private UsersService usersService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ParentTaskService parentTaskService;
	
	/* User Module EndPoints */

	//@CrossOrigin(origins = ANGULAR_URL)
	@RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
	public List<Users> findAllUsers() {
		return usersService.findAllUsers();
	}

	//@CrossOrigin(origins = ANGULAR_URL)
	@RequestMapping(value = "/saveUser", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	public Users saveUser(@RequestBody Users users) {
		System.out.println("Input Param");
		System.out.println(users.getUserId()+" >> " +
				users.getFirstName()+" >> "+
				users.getLastName()+" >> "+
				users.getEmployeeId()+" >> ");
		return usersService.saveUser(users);
	}

	//@CrossOrigin(origins = ANGULAR_URL)
//	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET) // or use @DeleteMapping
//	public void deleteUser(@RequestParam("user_id") int user_id) {
//		usersService.deleteUser(user_id);
//	}

	//@CrossOrigin(origins = ANGULAR_URL)
	@RequestMapping(value = "/deleteUser/{user_id}", method = RequestMethod.DELETE) // or use @DeleteMapping
	public void deleteUser(@PathVariable("user_id") int user_id) {
		usersService.deleteUser(user_id);
	}
	
	//@CrossOrigin(origins = ANGULAR_URL)
	@RequestMapping(value = "/findByFirstName", method = RequestMethod.GET) // or use @DeleteMapping
	public List<Users> findByFirstName(@RequestParam("first_name") String first_name) {
		return usersService.findUsersByFirstNameStartingWith(first_name);
	}

	@RequestMapping(value = "/findByUserID/{user_id}")
	public Optional<Users> findByUserID(@PathVariable("user_id") int user_id) {
		return usersService.findByUserID(user_id);
	}

	/* Project Module EndPoints */
	@RequestMapping(value = "/findAllProjects", method = RequestMethod.GET)
	public List<Project> findAllProjects() {
		return projectService.findAllProjects();
	}

	@RequestMapping(value = "/saveProject", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	public Project saveProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}

	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET) // or use @DeleteMapping
	public void deleteProject(@RequestParam("project_id") int project_id) {
		projectService.deleteProject(project_id);
	}

	@RequestMapping(value = "/findByProjectID/{project_id}")
	public Optional<Project> findByProjectID(@PathVariable("project_id") int project_id) {
		return projectService.findByProjectID(project_id);
	}

	/* Task Module EndPoints */
	@RequestMapping(value = "/findAllTasks", method = RequestMethod.GET)
	public List<Task> findAllTasks() {
		return taskService.findAllTasks();
	}

	@RequestMapping(value = "/findByProjectId/{project_id}", method = RequestMethod.GET)
	public List<Task> findByProjectId(@PathVariable("project_id") int project_id) {
		return taskService.findByProjectId(project_id);
	}
	
	@RequestMapping(value = "/saveTask", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public void deleteTask(@RequestParam("task_id") int task_id) {
		taskService.deleteTask(task_id);
	}

	@RequestMapping(value = "/findByTaskID/{task_id}")
	public Optional<Task> findByTaskID(@PathVariable("task_id") int task_id) {
		return taskService.findByTaskID(task_id);
	}

	/* Parent Task Module EndPoints */
	@RequestMapping(value = "/findAllParentTasks", method = RequestMethod.GET)
	public List<ParentTask> findAllParentTasks() {
		return parentTaskService.findAllParentTasks();
	}

	@RequestMapping(value = "/saveParentTask", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	public ParentTask saveParentTask(@RequestBody ParentTask parentTask) {
		return parentTaskService.saveParentTask(parentTask);
	}

	@RequestMapping(value = "/deleteParentTask", method = RequestMethod.GET)
	public void deleteParentTask(@RequestParam("parenttask_id") int parenttask_id) {
		parentTaskService.deleteParentTask(parenttask_id);
	}

	@RequestMapping(value = "/findByParentTaskID/{parenttask_id}")
	public Optional<ParentTask> findByParentTaskID(@PathVariable("parenttask_id") int task_id) {
		return parentTaskService.findByParentTaskID(task_id);
	}
}
