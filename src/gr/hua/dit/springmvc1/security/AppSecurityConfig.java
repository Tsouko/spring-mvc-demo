package gr.hua.dit.springmvc1.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    


//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
//		.usersByUsernameQuery("SELECT USERS.id as username,password,enabled from USERS where id=? ")
//		.authoritiesByUsernameQuery("select authorities.id as username,authority from authorities where id=?");
		
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("SELECT users.id as username,password,enabled from users where id=? ")
		.authoritiesByUsernameQuery("select authorities.id as username,authority from authorities where id=?");
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/authorities/**").hasRole("ADMIN")
		.antMatchers("/student/addStudent").hasRole("ADMIN")
		.antMatchers("/office/addOffice").hasRole("ADMIN")
		.antMatchers("/student/list").hasAnyRole("ADMIN", "OFFICE")
		.antMatchers("/company/addCompany").hasRole("OFFICE")
		.antMatchers("/office/**").hasRole("OFFICE")
		.antMatchers("/student/**").hasRole("STUDENT")
		.antMatchers("/company/**").hasRole("COMPANY")
		.antMatchers("/**").authenticated()
		
		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/authUser").permitAll().and().logout().permitAll();
        }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}