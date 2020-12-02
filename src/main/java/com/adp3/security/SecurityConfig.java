package com.adp3.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String USER_ROLE = "user";
    private String ADMIN_ROLE = "admin";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Super")
                .password(encoder().encode("Password.ADP3"))
                .roles("ADMIN","USER")
                .and()
                .withUser("User")
                .password(encoder().encode("Password"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/leaveReport/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/leaveReport/read", "/employee_time_management/leaveReport/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/leaveReport/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/leaveReport/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/employee_time_management/employeeRole/read", "/employee_time_management/employeeRole/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/employeeRole/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/employeeSalary/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/employeeSalary/read", "/employee_time_management/employeeSalary/getAll").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/employeeSalary/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/employeeSalary/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/employeeLeave/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/employeeLeave/read", "/employee_time_management/employeeLeave/getAll").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/employeeLeave/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/employeeLeave/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/Store/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/Store/read", "/employee_time_management/Store/getAll").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/Store/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/Store/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/storeReports/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/storeReports/read", "/employee_time_management/storeReports/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/storeReports/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/storeReports/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/Employee/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/Employee/read", "/employee_time_management/Employee/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/Employee/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/Employee/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/EmployeeStore/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/EmployeeStore/read", "/employee_time_management/StoreReports/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/EmployeeStore/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/EmployeeStore/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/leave/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/leave/read", "/employee_time_management/leave/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT,"/employee_time_management/leave/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/leave/delete").hasRole(ADMIN_ROLE)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/employee_time_management/Role/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/employee_time_management/Role/read", "/employee_time_management/Role/getAll").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PATCH,"/employee_time_management/Role/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/employee_time_management/Role/delete").hasRole(ADMIN_ROLE)
                .and()

                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
         return new BCryptPasswordEncoder();
    }
}
