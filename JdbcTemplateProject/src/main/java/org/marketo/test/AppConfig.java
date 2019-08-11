package org.marketo.test;

import org.marketo.config.WebMvcConfig;
import org.marketo.dao.StudentDao;
import org.marketo.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfig {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebMvcConfig.class);
	StudentDao studentDao = context.getBean(StudentDao.class);
	System.out.println("List of person is:");
	for (Student p : studentDao.read()) {
		System.out.println(p);
	}
	System.out.println("\nCreating person: ");
	Student student = new Student(1,"kanhei","kanhei@gmail.com","math");
	Student student1 = new Student(1,"xyz","xyz@gmail.com","phy");
	Student student2 = new Student(1,"abc","abc@gmail.com","chem");
	System.out.println(student);
	studentDao.create(student);
	System.out.println("\nDeleting person with ID 2");
	studentDao.delete(student.getId());
	context.close();

}

}
