package com.libraryserver;

import com.libraryserver.serviceImpl.StudentDetailServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class LibraryServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryServerApplication.class, args);
	}

}
