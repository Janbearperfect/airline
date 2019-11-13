package airsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.User;
import airsystem.service.prototype.UsersService;

@Controller
public class UsersController {
    
	@Autowired
	private UsersService userService;
	
	@RequestMapping("/users")
	public ModelAndView listUsers() {
		ModelAndView mv=new ModelAndView("users");
		List<User> list=userService.listUser();
		mv.addObject("users",list);
		return mv;
		
	}
}
