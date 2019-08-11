package org.marketo.dao;

import java.util.List;

import org.marketo.model.Student;

public interface StudentDao {
	public int create(Student student);

	public List<Student> read();

	int delete(int studentId);
}
