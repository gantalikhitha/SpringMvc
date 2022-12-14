package com.net;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.net.Model.Student;
import com.net.Repository.StudentRepository;
import com.net.Service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootThymeleafCrudExApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void saveTest() {
		Student student = new Student(1, "siva", "gpl");
		when(studentRepository.save(student)).thenReturn(student);
		// assertEquals(student, studentService.saveStudent(student));
	}

	@Test
	public void deleteTest() {
		Student student = new Student(5, "siva", "gpl");
		studentService.deleteStudentById(student);
		verify(studentRepository, times(1)).delete(student);
	}

}
