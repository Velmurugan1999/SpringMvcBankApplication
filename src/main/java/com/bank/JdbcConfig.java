package com.bank;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bank.dao.BankDao;

@Configuration
@EnableWebMvc
@ComponentScan("com.bank")
public class JdbcConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dms=new DriverManagerDataSource("jdbc:mysql://localhost:3306/company","root","root");
		dms.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dms;
		
	}
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate()
	{
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	@Bean
	public BankDao getDao()
	{
		BankDao dao=new BankDao();
		dao.setTemplate(getJdbcTemplate());
		return dao;
	}
	
}
