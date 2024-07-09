package com.security.databaseImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.dto.UserDto;

@Component
public class UserDetailsImpl implements UserDetailsService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String sqlLoadUserByUsername="select username,password,role "
			+ "from users "
			+ "where username = ?";
	private String  sqlCreateUserOtherDetails="insert into userotherdetails (name, email, mobileNumber,address) values (?,?,?,?)";
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDto>  studentList=jdbcTemplate.query(sqlLoadUserByUsername, new BeanPropertyRowMapper(UserDto.class),username);
		if(studentList==null) {
			throw new RuntimeException("user doesn't exist...");
		}
		UserDetails userDetails=User.withUsername(studentList.get(0).getName())
									.password(studentList.get(0).getPassword())
									.roles(studentList.get(0).getRole())
									.build();
									
		return userDetails;
	}
	
	public void createUserOtherDetails(String name,String email,String mobileNumber,String address) {
		jdbcTemplate.update(sqlCreateUserOtherDetails,name, email, mobileNumber,address);
	}

}
