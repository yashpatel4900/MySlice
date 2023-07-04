package com.university.MySlice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.university.MySlice")
public class MySliceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MySliceApplication.class, args);
	}

}
