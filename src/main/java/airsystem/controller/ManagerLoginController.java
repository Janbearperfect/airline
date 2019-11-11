package airsystem.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import airsystem.entity.Manager;
import airsystem.service.prototype.ManagerService;

@Controller
public class ManagerLoginController {
	@Autowired
	private ManagerService ms;
	@RequestMapping("/managerLogin")
	public void managerLogin() {
		
	}
	
	@RequestMapping("/checkManagerLogin")
	public void checkManagerLogin(HttpServletRequest request,HttpServletResponse reponse) throws IOException {
		String name=new String(request.getParameter("mname").getBytes("8859_1"),"utf-8");
		String password=new String(request.getParameter("password").getBytes("8859_1"),"utf-8");
		Manager manager=ms.findManager(name);
		if(password.equals(manager.getPassword())) {
			reponse.sendRedirect("main");
		}else {
			reponse.sendRedirect("managerLogin");
		}
		
	}
}
