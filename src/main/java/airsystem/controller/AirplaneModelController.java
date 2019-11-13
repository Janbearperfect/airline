package airsystem.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	@RequestMapping("/airplaneUpdate")
	public void updateAirplane(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String airplane = new String(request.getParameter("airplane").getBytes("8859_1"),"utf-8");
		String model = new String(request.getParameter("model").getBytes("8859_1"),"utf-8");
		Integer max_sail_length=Integer.parseInt(request.getParameter("max_sail_length"));
		Integer first_class_seats=Integer.parseInt(request.getParameter("first_class_seats"));
		Integer business_class_seats=Integer.parseInt(request.getParameter("business_class_seats"));
		Integer economy_class_seats=Integer.parseInt(request.getParameter("economy_class_seats"));
		
		AirplaneModel a=new AirplaneModel();
		
		a.setAirplane(airplane);
		a.setBusiness_class_seats(business_class_seats);
		a.setEconomy_class_seats(economy_class_seats);
		a.setFirst_class_seats(first_class_seats);
		a.setMax_sail_length(max_sail_length);
		a.setModel(model);
		
		ams.Update(a);
		
		response.sendRedirect("airplaneModel");
	}
	
	@RequestMapping("/airplaneSave")
	public void saveAirplane(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String airplane = new String(request.getParameter("airplane").getBytes("8859_1"),"utf-8");
		String model = new String(request.getParameter("model").getBytes("8859_1"),"utf-8");
	
		Integer max_sail_length=Integer.parseInt(request.getParameter("max_sail_length"));
		Integer first_class_seats=Integer.parseInt(request.getParameter("first_class_seats"));
		Integer business_class_seats=Integer.parseInt(request.getParameter("business_class_seats"));
		Integer economy_class_seats=Integer.parseInt(request.getParameter("economy_class_seats"));
		
		AirplaneModel a=new AirplaneModel();
		
		a.setAirplane(airplane);
		a.setBusiness_class_seats(business_class_seats);
		a.setEconomy_class_seats(economy_class_seats);
		a.setFirst_class_seats(first_class_seats);
		a.setMax_sail_length(max_sail_length);
		a.setModel(model);
		
		ams.save(a);
		
		response.sendRedirect("airplaneModel");
	}
	
	@RequestMapping("/airplaneDelete/{airplane}")
	@ResponseBody
	public String branchDelete(@PathVariable("airplane") String airplane) throws UnsupportedEncodingException {
		String ap= new String(airplane.getBytes("8859_1"),"utf-8");
		ams.deleteAirportModel(ap);
		return "success";
	}
}
