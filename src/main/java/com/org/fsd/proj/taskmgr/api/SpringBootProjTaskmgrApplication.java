package com.org.fsd.proj.taskmgr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootProjTaskmgrApplication extends SpringBootServletInitializer {
	/* SpringBootServletInitializer extended to generate the war file and deploy the application in external tomcat*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjTaskmgrApplication.class, args);
	}

}

