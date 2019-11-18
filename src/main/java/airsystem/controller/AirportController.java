package airsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import airsystem.entity.Airport;
import airsystem.service.prototype.AirportService;

@Controller
public class AirportController {
	@Autowired
	private AirportService airportService;
	@RequestMapping("/main")
	public void showMain(HttpSession session) {
//		System.out.println(session.getAttribute("adminId"));
		
	}
	
	@RequestMapping("/airport")
	public ModelAndView showAirport(HttpSession session) {
		ModelAndView mv = new ModelAndView("airport");
		List<Airport> airports = airportService.listAirport();
		mv.addObject("airports", airports);
//		System.out.println(session.getAttribute("adminId"));
		return mv; 
	}
	@RequestMapping("/deleteAirport/{airportCode}")
	@ResponseBody
	public String airportDelete(@PathVariable("airportCode") String airportCode) {
		airportService.deleteAirport(airportCode);
		return "success";
	}
	@RequestMapping(value="/getAirport/{airportCode}",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getAirport(@PathVariable("airportCode") String airportCode) {
		Airport airport = airportService.getAirport(airportCode);
		return JSON.toJSONString(airport);
	}
	@RequestMapping(value="/updateAirport/{airportCode}/{city}/{airportName}")
	@ResponseBody
	public String updateAirport(@PathVariable("airportCode") String airportCode,@PathVariable("city") String city,@PathVariable("airportName") String airportName) {
		airportService.updateAirport(airportCode, city, airportName);
		return "success";
	}
	@RequestMapping("/saveAirport/{airportCode}/{city}/{airportName}")
	@ResponseBody
	public String saveAirport(@PathVariable("airportCode") String airportCode,@PathVariable("city") String city,@PathVariable("airportName") String airportName) {
		Airport airport = new Airport();
//		String airportCode  = request.getParameter("airportCode");
//		String city = request.getParameter("city");
//		String airportName = request.getParameter("airportName");
		airport.setAirportCode(airportCode);
		airport.setCity(city);
		airport.setAirportName(airportName);
		airportService.saveAirport(airport);
		return "success";
	}
}





