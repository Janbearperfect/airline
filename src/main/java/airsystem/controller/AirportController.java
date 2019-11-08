package airsystem.controller;

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
	@RequestMapping("/saveAirport/{airportCode}")
	@ResponseBody
	public String airportDelete(@PathVariable("airportCode") String airportCode) {
		airportService.deleteAirport(airportCode);
		return "success";
	}
	@RequestMapping("/getAirport/{airportCode}")
	@ResponseBody
	public String airportgetAirport(@PathVariable("airportCode") String airportCode) {
		Airport airport = airportService.getAirport(airportCode);
		String air = JSON.toJSONString(airport);
		return air;
	}
}
