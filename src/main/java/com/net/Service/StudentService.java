package com.net.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.net.Model.Student;

@Service
public interface StudentService {
	List<Student> getAllStudents();
	void saveStudent (Student student);
	Student getStudentById(long id);
	void deleteStudentById(Student student);
	Page<Student> findPaginated(int pageNo, int pageSize);

}
