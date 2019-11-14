package airsystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import airsystem.entity.UserL;
import airsystem.service.prototype.UserService;

@Controller
public class UserLoginController {
	@Autowired
	private UserService us;
	
	@RequestMapping("/yZreg")
	@ResponseBody
	public String yZreg(HttpServletRequest request) {
		String phone = request.getParameter("phone");
	    int is=	us.isHavePhone(phone);
	    if(is!=0) {
	    	return "false";
	    }else {
	    	return "true";
	    }
		
	}
	
	@RequestMapping("/regCommit")
	public void regCommit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		
		UserL user = new UserL();
		user.setAddress(address);
		user.setAge(age);
		user.setUname(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);
		
		us.saveUser(user);
		response.sendRedirect("index");
	}
	
	@RequestMapping("/userLogin")
	public void userLogin() {
		
	}
	
	@RequestMapping("/yZphone")
	@ResponseBody
	public String yZphone(HttpServletRequest request) {
		String phone = request.getParameter("phone");
	
	    int is=	us.isHavePhone(phone);
	    if(is!=0) {
	    	return "true";
	    }else {
	    	return "false";
	    }
		
	}
}
