package com.ecomm.beecasual.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configUser(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select userName,userPassword, enabled from User where userName=?").authoritiesByUsernameQuery("select username,rolename from user u,role r,userrole ur where u.userid=ur.userid and r.roleid=ur.roleid and username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/category","/subCategory","/brand","/supplier","/product").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").failureUrl("/login?error")
		.usernameParameter("userName").passwordParameter("userPassword").loginProcessingUrl("/perform_login").defaultSuccessUrl("/")
//		.and()
//		.logout().logoutSuccessUrl("/perform_logout")
		.and()
		
		
		.csrf().disable();
		
	}
}
