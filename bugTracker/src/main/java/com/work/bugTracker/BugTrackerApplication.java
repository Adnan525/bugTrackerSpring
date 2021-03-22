package com.work.bugTracker;

import com.work.bugTracker.dataModel.BugModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BugTrackerApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}

}
