CREATE TABLE `projtaskmgr`.`users` (
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `employee_id` INT NOT NULL,
  PRIMARY KEY (`user_id`));

CREATE TABLE `projtaskmgr`.`project` (
  `project_id` INT NOT NULL,
  `project` VARCHAR(150) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `priority` int not null,
  PRIMARY KEY (`project_id`));

ALTER TABLE `projtaskmgr`.`project` 
ADD COLUMN `user_id` INT NOT NULL AFTER `priority`,
ADD INDEX `fk_user_id_idx` (`user_id` ASC) ;
;
ALTER TABLE `projtaskmgr`.`project` 
ADD CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `projtaskmgr`.`users` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  CREATE TABLE `projtaskmgr`.`parent_task` (
  `parent_id` INT NOT NULL,
  `parent_task` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`parent_id`));
  
  CREATE TABLE `projtaskmgr`.`task` (
  `task_id` INT NOT NULL,
  `parent_id` INT NULL,
  `project_id` INT NOT NULL,
  `task` VARCHAR(45) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `priority` INT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`task_id`),
  INDEX `fk_parent_id_idx` (`parent_id` ASC) ,
  INDEX `fk_project_id_idx` (`project_id` ASC) ,
  CONSTRAINT `fk_parent_id`
    FOREIGN KEY (`parent_id`)
    REFERENCES `projtaskmgr`.`parent_task` (`parent_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `projtaskmgr`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    ALTER TABLE `projtaskmgr`.`project` 
ADD COLUMN `status` VARCHAR(45) NULL AFTER `user_id`;
ALTER TABLE `projtaskmgr`.`project` 
CHANGE COLUMN `status` `status` VARCHAR(45) NULL DEFAULT 'New' ;
ALTER TABLE `projtaskmgr`.`task` 
CHANGE COLUMN `status` `status` VARCHAR(45) NULL DEFAULT 'In Progress' ;
  
  
  ====================================================
  insert into projtaskmgr.users (user_id,first_name,last_name,employee_id) values (1,'John','Ma',1);
  insert into projtaskmgr.users (user_id,first_name,last_name,employee_id) values (2,'Mike','Ma',2);
   insert into projtaskmgr.project (project_id,project,start_date,end_date,priority,user_id) values 
 (1,'Project 1','2019-11-11','2019-11-12',1,1);
   insert into projtaskmgr.parent_task (parent_id,parent_task) values   (1,'Parent Task 1');
      insert into projtaskmgr.task (task_id,parent_id,project_id,task,start_date,end_date,priority,status) values 
 (1,1,1,'task 1','2019-11-11','2019-11-12',1,null);
commit;