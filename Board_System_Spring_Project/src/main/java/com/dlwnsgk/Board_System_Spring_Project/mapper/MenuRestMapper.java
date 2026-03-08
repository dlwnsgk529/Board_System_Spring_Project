package com.dlwnsgk.Board_System_Spring_Project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dlwnsgk.Board_System_Spring_Project.entity.Menu;

@Mapper
public interface MenuRestMapper {
	
	@Insert("INSERT INTO backend_spring_project.menu(memID, title, content, writer, indate) VALUES (#{memID}, #{title}, #{content}, #{writer}, #{indate})")
	public void boardInsert(Menu menu);
	
	// Bring all data from DB by descending order
	@Select("SELECT idx, memID, title, content, writer, indate, count FROM backend_spring_project.menu ORDER BY idx DESC")
	public List<Menu> getLists();
	
	// Get post content
	@Select("SELECT idx, memID, title, content, writer, indate, count FROM backend_spring_project.menu WHERE idx=#{idx}")
	public Menu boardContent(int idx);
	
	@Update("UPDATE backend_spring_project.menu SET title=#{title}, content=#{content}, writer=#{writer} WHERE idx=#{idx}")
	public void boardUpdate(Menu menu);
	
	@Update("UPDATE backend_spring_project.menu SET count = count+1 WHERE idx=#{idx}")
	public void boardCount(int idx);
	
	@Delete("DELETE FROM backend_spring_project.menu WHERE idx=#{idx}")
	public void boardDelete(int idx);	
}
