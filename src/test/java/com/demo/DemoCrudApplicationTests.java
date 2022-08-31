package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class DemoCrudApplicationTests {
	
	@Autowired
	private StudentRepository studentrepo;

	@Test
	void saveOneStudent() {
		Student s1 = new Student();
		s1.setName("stallin");
		s1.setCourse("development");
		s1.setFee(22000);
		studentrepo.save(s1);
	}
	
	@Test
	void deleteOneStudent () {
		studentrepo.deleteById(2l);
	}
	
	@Test
	void getOneStudent() {
		Optional<Student> findById = studentrepo.findById(33l);
		if (findById.isPresent()) {
			Student student = findById.get();
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
			System.out.println(student.getId());
		} else {
			System.out.println("Data not found!!!");

		}
	}
	
	@Test
	void updateOneStudent () {
		Optional<Student> findById = studentrepo.findById(2l);
		if (findById.isPresent()) {
			Student student = findById.get();
			student.setName("mike");
			student.setCourse("testing");
			student.setFee(30000);
			studentrepo.save(student);
			
		} else {
			System.out.println("Data not found");

		}
		
	}
	
	@Test
	void getAllStudent() {
		Iterable<Student> findAll = studentrepo.findAll();
	
		for (Student student : findAll) {
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
			
			
		}
	}

}
