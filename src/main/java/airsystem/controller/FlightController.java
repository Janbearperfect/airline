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
import airsystem.entity.Flight;
import airsystem.service.prototype.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
    
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/flightview")
	public ModelAndView listFlightView() {
		ModelAndView mv=new ModelAndView("flightview");
		
		List<Flight> list=flightService.listFlight();
		mv.addObject("flights",list);
		return mv;
		
		
	}
	
	@RequestMapping(value="/getFlightView/{flightId}",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getAirport(@PathVariable("flightId") int flightId) {
		Flight flight=flightService.getFlight(flightId);
		return JSON.toJSONString(flight);
	}
	@RequestMapping(value="/updateFlightView/{seasonDiscount}/{price}/{flightId}")
	@ResponseBody
	public String updateFlightView(@PathVariable("seasonDiscount") double seasonDiscount,@PathVariable("price") double price,@PathVariable("flightId") int flightId) {
		
		flightService.updateFlight(seasonDiscount, price, flightId);
		return "success";
	}
	
}
