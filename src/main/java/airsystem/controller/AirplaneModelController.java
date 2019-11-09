package airsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.AirplaneModel;

import airsystem.service.prototype.AirplaneModelService;

@Controller
public class AirplaneModelController {
	@Autowired
	private AirplaneModelService ams;
	

	@RequestMapping("/airplaneModel")
	public  ModelAndView getBranch() {
		ModelAndView mv = new ModelAndView("airplaneModel");
		List<AirplaneModel> am = ams.findAll();
		mv.addObject("ams",am);
		return mv;
	}
}
