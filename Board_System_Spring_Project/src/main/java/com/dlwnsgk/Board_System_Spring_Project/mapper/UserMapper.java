package com.dlwnsgk.Board_System_Spring_Project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.dlwnsgk.Board_System_Spring_Project.entity.User;

@Mapper
// automatically added to Spring Container w/ @Mapper
// Allows MySQL and JAVA to understand each other
public interface UserMapper {
	
	@Insert("INSERT INTO backend_spring_project.user(username, password, writer, role)"+ "VALUES(#{username},#{password}, #{writer}, #{role})")
	void insertUser(User user);
	
	@Select("SELECT username, password, writer, role FROM backend_spring_project.user WHERE username=#{username}")
	User findByUsername(String username);
	
	@Select("SELECT writer FROM backend_spring_project.user WHERE username=#{username}")
	String findWriter(String username);
	
//	@Update()
	
//	@Delete()
}
