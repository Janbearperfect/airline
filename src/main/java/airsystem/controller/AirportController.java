package airsystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void showMain() {
		
	}
	
	@RequestMapping("/airport")
	public ModelAndView showAirport() {
		ModelAndView mv = new ModelAndView("airport");
		List<Airport> airports = airportService.listAirport();
		mv.addObject("airports", airports);
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
		try {
			airportCode = new String(airportCode.getBytes("8859_1"),"utf-8");
			city = new String(city.getBytes("8859_1"),"utf-8");
			airportName = new String(airportName.getBytes("8859_1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		airportService.updateAirport(airportCode, city, airportName);
		return "success";
	}
	@RequestMapping("/saveAirport")
	@ResponseBody
	public String saveAirport() {
		
		return "";
	}
}





