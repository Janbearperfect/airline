package airsystem.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.FlightSchedulerDao;
import airsystem.entity.FlightScheduler;
import airsystem.service.prototype.FlightSchedulerService;

@Service
public class FlightSchedulerServieImpl implements FlightSchedulerService{
	
	@Autowired
	private FlightSchedulerDao  fsd;
		//≤È—Øµ±«∞∫Ω∞‡

	@Override
	public String saveFlightScheduler(String flightNumber, String startDate, String endDate, String fromCity,
			String toCity, String departureTime, String arrivalTime, String airplane, String scheduler,
			int sailLength) {
		
		return fsd.saveFlightScheduler(flightNumber, startDate, endDate, fromCity, toCity, departureTime, arrivalTime, airplane, scheduler, sailLength);
	}

	@Override
	public String deleteFlightScheduler(int id) {
		
		return fsd.deleteFlightScheduler(id);
	}

	@Override
	public String updateString(int id, String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength) {
		
		return fsd.updateString(id,flightNumber, startDate, endDate, fromCity, toCity,
				departureTime, arrivalTime, airplane, scheduler, sailLength);
	}

	@Override
	public int totalItems() {
		// TODO Auto-generated method stub
		return fsd.totalItems();
	}

	@Override
	public List<FlightScheduler> listFlightSchedulerService() {
		// TODO Auto-generated method stub
		return fsd.listFlightScheduler();
	}

	@Override
	public FlightScheduler getFlightScheduler(int id) {
		return fsd.getFlightScheduler(id);
	}

	@Override
	public List<FlightScheduler> listNowFlightService() {
		
		return fsd.listNowFlightDao();
	}

	@Override
	public List<FlightScheduler> listOutFlightService() {
		// TODO Auto-generated method stub
		return fsd.listOutFlightDao();
	}

}
