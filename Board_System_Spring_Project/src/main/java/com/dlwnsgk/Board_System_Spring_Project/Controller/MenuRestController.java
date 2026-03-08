package com.dlwnsgk.Board_System_Spring_Project.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dlwnsgk.Board_System_Spring_Project.entity.Menu;
import com.dlwnsgk.Board_System_Spring_Project.service.MenuRestService;

// used when RESTAPI is used, returns data: text / json. (@Controller returns page)
@RestController
public class MenuRestController {
	
	private MenuRestService menuRestService;
	
	public MenuRestController(MenuRestService menuRestService) {
		this.menuRestService = menuRestService;
	}
	
	// bring all posts
	@GetMapping("/menu/all")
	public ResponseEntity<List<Menu>>getAllMenus(){
		// ResponseEntity can return status code and data
		List<Menu> menus = menuRestService.getLists(); // get all post
		
		if( menus!= null && !menus.isEmpty() ) { // if not empty
			return ResponseEntity.ok(menus); // status code 200
		}
		else {
			return ResponseEntity.noContent().build(); // status code 204, means no content
		}
	}
	
	// create post to DB
	@PostMapping("/menu/add")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu){ // @RequestBody maps json from path to Menu's properties
		if(menu.getIndate() == null || menu.getIndate().isEmpty()) {
			menu.setIndate(LocalDate.now().toString()); // set written date to curr date automatically
		}
		menu.setCount(0); // set view count to 0
		
		menuRestService.boardInsert(menu);
		
		return ResponseEntity.ok("Successfully posted!");
	}
	
	// edit post
	@PutMapping("menu/update/{idx}")
	public void updateMenu(@RequestBody Menu menu, @PathVariable("idx") int idx) { // @PathVariable maps {idx} in path to int idx
		menu.setIdx(idx); // set menu variable's idx to edited post's idx
		menuRestService.boardUpdate(menu); // update data
	}
	
	// delete post
	@DeleteMapping("/menu/delete/{idx}")
	public void deleteMenu(@PathVariable("idx") int idx) {
		menuRestService.boardDelete(idx);
	}
	
	// Read post
	@GetMapping("/menu/{idx}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("idx") int idx){
		Menu menu = menuRestService.boardContent(idx);
		
		if(menu != null) {
			return ResponseEntity.ok(menu); // Status code 200, and send Menu from back to front
		}
		else {
			return ResponseEntity.notFound().build(); // status code 404, post does not exist
		}
		
	}
		
	// increment view count for each post
	@PutMapping("/menu/count/{idx}")
	public void incrementMenuCount(@PathVariable("idx") int idx) {
		menuRestService.boardCount(idx);
	}
	
}
