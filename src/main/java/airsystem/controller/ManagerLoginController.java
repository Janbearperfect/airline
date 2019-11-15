package airsystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import airsystem.entity.Branch;
import airsystem.entity.Manager;
import airsystem.entity.Sales;
import airsystem.service.prototype.ManagerService;

@Controller
public class ManagerLoginController {
	@Autowired
	private ManagerService ms;
	@RequestMapping("/managerLogin")
	public void managerLogin() {
	}
	
	@RequestMapping("/checkManagerLogin")
	@ResponseBody
	public String checkManagerLogin(HttpServletRequest request,HttpServletResponse reponse,HttpSession session) throws IOException {

		String num = request.getParameter("mname");
		String password = request.getParameter("password");
		int type = Integer.parseInt(request.getParameter("type"));
		if(type==1) {
			Manager manager=ms.findManager(num);
			System.out.println(manager);
			if(password.equals(manager.getPassword())&&num.equals(manager.getNumber())) {
				session.setAttribute("adminId", manager.getId());
				session.setAttribute("name", manager.getName());
				return "success";
			}else {
				return "failure";
			}
		}else if(type==2) {
			Branch branch = ms.findBranch(num);
			System.out.println(branch);
			if(password.equals(branch.getbPassword())) {
				session.setAttribute("adminId", branch.getId());
				session.setAttribute("name", branch.getName());
				return "success";
			}else {
				return "failure";
			}
		}else {
			Sales sale= ms.findSale(num);
			if(password.equals(sale.getPassword())&&num.equals(sale.getNumber())) {
				session.setAttribute("adminId", sale.getId());
				session.setAttribute("name", sale.getName());
				return "success";
			}else {
				return "failure";
			}
		}
	}
}
