package org.marketo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.marketo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public int create(Student student) {
		String sql = "insert into student1(stu_name,stu_email,stu_course) values(?,?,?)";
		return jdbcTemplate.update(sql);
	}

	@SuppressWarnings("unchecked")
	public List<Student> read() {
		String sql="SELECT * FROM STUDENT1";
		return (List<Student>) jdbcTemplate.queryForObject(sql,Student.class);
	}
	
	public int delete(int studentId) {
		String sql = "delete from student1 where stu_id=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { studentId });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	}

