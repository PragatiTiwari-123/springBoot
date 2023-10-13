package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class CruddemoApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(CruddemoApplicationTests.class);
	@Autowired
	private StudentRepository studentRepo;
	@Test
	void saveStudent() {
        logger.info("First");
        logger.error("This is an error message.");
		Student s = new Student();
		s.setName("adam");
		s.setCourse("Dev");
		s.setFee(100000);		
		studentRepo.save(s);
        logger.info("Second");
        logger.error("This is an error message.");
	}
	@Test
	public void deleteStudentInformation() {
		studentRepo.deleteById(10);
	}
	@Test
	public void findStudentById(){
		Optional<Student> findById = studentRepo.findById(10);
		if(findById.isPresent()) {
			Student student = findById.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}else {
		System.out.println("No record found");
		}
	}
//	Always select that query whenever needs to run and always remember delete extra spaces in code
	@Test
	public void updateStudentInfo() {
		Optional<Student> obj = studentRepo.findById(8);
		Student student = obj.get();
		student.setFee(20000);
		studentRepo.save(student);
	}
	@Test
	public void findStudentExist() {
		boolean val = studentRepo.existsById(6);
		System.out.println(val);
	}
	@Test
	public void getAllRecords() {
		Iterable<Student> findAll = studentRepo.findAll();
		for(Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
	}

}
