package com.dlwnsgk.Board_System_Spring_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlwnsgk.Board_System_Spring_Project.entity.Menu;
import com.dlwnsgk.Board_System_Spring_Project.mapper.MenuRestMapper;

@Service
public class MenuRestService {
	
	private MenuRestMapper menuRestMapper;
	
	@Autowired
	public MenuRestService(MenuRestMapper menuRestMapper) {
		this.menuRestMapper = menuRestMapper;
	}
	
	public void boardInsert(Menu menu) {
		menuRestMapper.boardInsert(menu);
	}
	
	public List<Menu> getLists(){
		return menuRestMapper.getLists();
	}
	
	public Menu boardContent(int idx) {
		return menuRestMapper.boardContent(idx);
	}
	
	public void boardUpdate(Menu menu) {
		menuRestMapper.boardUpdate(menu);
	}
	
	public void boardCount(int idx) {
		menuRestMapper.boardCount(idx);
	}
	
	public void boardDelete(int idx) {
		menuRestMapper.boardDelete(idx);
	}
}
