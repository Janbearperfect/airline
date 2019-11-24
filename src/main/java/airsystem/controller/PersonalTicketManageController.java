package airsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import airsystem.service.prototype.PersonalTicketManageService;

@Controller
public class PersonalTicketManageController {
	@Autowired
	private PersonalTicketManageService ptms;
	
	@RequestMapping("/returnTicket/{id}")
	@ResponseBody
	public String returnTicket(@PathVariable("id") int  id) {
		System.out.println(id);
		if(ptms.personalReturnTicket(id)) {
			return "success";
		}else {
			return "failure";
		}
	
	}
	
	
}
