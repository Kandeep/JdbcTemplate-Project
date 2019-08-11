package org.marketo.controller;

import org.marketo.dao.StudentDao;
import org.marketo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateController {
	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int createStudent(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("course") String course) {

		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setCourse(course);

		int counter = studentDao.create(student);

		if (counter > 0) {
			return counter;
		} else {
			return 0;
		}
	}
}