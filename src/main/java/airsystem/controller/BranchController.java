package airsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.Branch;
import airsystem.service.prototype.BranchService;


@Controller
public class BranchController {
	@Autowired
	private BranchService branch;
	
	

	

	@RequestMapping("/branch")
	public  ModelAndView getBranch() {
		ModelAndView mv = new ModelAndView("branch");
		List<Branch> brs=branch.findAll();
		
		mv.addObject("brs",brs);
		return mv;
	}
}
