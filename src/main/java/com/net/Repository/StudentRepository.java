package com.net.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.net.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	void delete(Student student);

	

}
