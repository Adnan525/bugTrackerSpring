//database using "test" from postgres with postgres user
//DB initiall empty
//run program will create 2 tables at public schema - bugs and tracker_users
package com.work.bugTracker;

import com.work.bugTracker.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = RepositoryUser.class)
public class BugTrackerApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}

}
