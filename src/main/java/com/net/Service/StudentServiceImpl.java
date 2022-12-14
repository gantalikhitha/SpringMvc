package com.net.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.net.Model.Student;
import com.net.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);

	}

	@Override
	public Student getStudentById(long id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			throw new RuntimeException("Student not found id::" + id);
		}

		return student;
	}

	@Override
	public void deleteStudentById(Student student) {

		this.studentRepository.delete(student);
	}

	@Override
	public Page<Student> findPaginated(int pageNo, int pageSize) {
	org.springframework.data.domain.Pageable pageable=PageRequest.of(pageNo-1, pageSize);
	
		return this.studentRepository.findAll(pageable);
	}

	

}
