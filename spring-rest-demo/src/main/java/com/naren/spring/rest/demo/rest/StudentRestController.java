package com.naren.spring.rest.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naren.spring.rest.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> studentList;

	@PostConstruct
	public void loadStudentData() {
		System.out.println("==loadStudentData===");
		studentList = new ArrayList<Student>();
		studentList.add(new Student("Naren", "Mehta"));
		studentList.add(new Student("Deepak", "Kasgar"));
		studentList.add(new Student("Prema", "H"));
	}

	@GetMapping("/students/{studentIndex}")
	public Student getStudentByName(@PathVariable int studentIndex) {

		if (studentIndex >= studentList.size() || studentIndex < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentIndex);
		}
//		System.out.println(10/0);
		return studentList.get(studentIndex);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentList;
	}
	
}
