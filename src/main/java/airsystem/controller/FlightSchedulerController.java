package airsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import airsystem.service.prototype.FlightSchedulerService;

/**
 * ∫Ω∞‡º∆ªÆ±Ì
 * @author ’‘ §ÃŒ
 *
 */
@SuppressWarnings("unused")
@Controller
public class FlightSchedulerController {
	@Autowired
	private FlightSchedulerService fss;
	@RequestMapping("/flightscheduler")
	@ResponseBody
	public List<FlightSchedulerService> listFlightScheduler(){
		
		return null;
		
	}
	
}
