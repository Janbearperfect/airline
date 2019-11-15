package airsystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import airsystem.entity.UserL;
import airsystem.service.prototype.UserService;

@Controller
public class PersonalCenter {
	@Autowired
	private UserService us;
	@RequestMapping("/personalCenter")
	public void personalCenter() {
		
	}
	@RequestMapping("/updatePersonal")
	public void updatePersonal(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		UserL user =(UserL)session.getAttribute("user");
		String uname = request.getParameter("userName");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
	
		user.setUname(uname);
		user.setSex(sex);
		user.setAge(age);
		user.setAddress(address);
		us.updateUser(user);
		response.sendRedirect("personalCenter");
	}
}
