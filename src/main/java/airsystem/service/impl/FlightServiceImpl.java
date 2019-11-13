package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.FlightDao;
import airsystem.entity.Flight;
import airsystem.service.prototype.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
    
	@Autowired
	private FlightDao  flightDao;
	

	

	@Override
	public Flight getFlight(String flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> listFlight() {
		// TODO Auto-generated method stub
		return flightDao.listFlight();
	}

	@Override
	public int totalItems() {
		// TODO Auto-generated method stub
		return flightDao.totalItems();
	}

	@Override
	public void updateFlight(double seasonDiscount, double price, int flightId) {
	
		 flightDao.updateFlight(seasonDiscount, price, flightId);
	}

	@Override
	public Flight getFlight(int flightId) {
		// TODO Auto-generated method stub
		return flightDao.getFlight(flightId);
	}

	@Override
	public void updateFlightSeat(int flightId, int classes, int num) {
		flightDao.updateFlightSeat(flightId, classes, num);
	}

	@Override
	public int searchFlightId(String flightNumber) {
		return flightDao.searchFlightId(flightNumber);
	}

}
