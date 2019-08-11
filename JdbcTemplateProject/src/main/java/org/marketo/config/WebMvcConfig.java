package org.marketo.config;

import org.marketo.dao.StudentDao;
import org.marketo.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("org.marketo")
public class WebMvcConfig {
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/testBetacust");
		ds.setUsername("root");
		ds.setPassword("marketo17");

		return ds;
	}

	@Bean
	public StudentDao getUserDao() {
		return new StudentDaoImpl(getDataSource());
	}
}
