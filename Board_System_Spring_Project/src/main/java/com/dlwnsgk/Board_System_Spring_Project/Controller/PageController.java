package com.dlwnsgk.Board_System_Spring_Project.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dlwnsgk.Board_System_Spring_Project.entity.Menu;
import com.dlwnsgk.Board_System_Spring_Project.service.MenuRestService;
import com.dlwnsgk.Board_System_Spring_Project.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

//@Controller involves @Component, which labels the class to be registered in Spring Bean
@Controller
public class PageController {
	
	private UserService userService;
	private MenuRestService menuRestService;
	
	public PageController(UserService userService, MenuRestService menuRestService) {
		this.userService = userService;
		this.menuRestService = menuRestService;
	}
	
	// "/" => localhost:8080. Use @GetMapping() to switch pages
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/registerPage")
	public String registerPage(HttpServletRequest request, Model model) {
		
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName()); // fetches token
		model.addAttribute("_csrf",csrfToken); // allow "/register/index.jsp" to user token with the name "_csrf". Can approach attribute with '${}'
		
		return "register/index";
	}
	
	@GetMapping("/loginPage")
	public String loginPage(HttpServletRequest request, Model model) {
		
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName()); // fetches token
		model.addAttribute("_csrf",csrfToken); // allow "/register/index.jsp" to use token with the name "_csrf". Can approach attribute with '${}'
		
		return "login/index";
	}
	
	@GetMapping("/noticeAddPage")
	public String noticeAddPage(Model model, Authentication authentication) { // Authentication brings info that can be used like username, authority etc.
		String writer = userService.findWriter(authentication.getName());
		model.addAttribute("writer", writer);
		
		return "noticeAdd/index";
	}
	
	
	@GetMapping("/noticeCheckPage")
	public String noticeCheckPage(@RequestParam("idx") int idx, Model model) {
		Menu menu = menuRestService.boardContent(idx);
		model.addAttribute("menu", menu);
		
		return "noticeCheck/index";
	}
	
	@GetMapping("/noticeEditPage")
	public String noticeEditPage(@RequestParam("idx") int idx, Model model) {
		Menu menu = menuRestService.boardContent(idx);
		model.addAttribute(menu);
		
		return "noticeEdit/index";
	}
	
}
