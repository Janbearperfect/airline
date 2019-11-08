package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.AirportDao;
import airsystem.entity.Airport;
import airsystem.service.prototype.AirportService;
@Service
public class AirportServiceImpl implements AirportService{
	@Autowired
	private AirportDao Iao;
	@Override
	public void deleteAirport(String airportCode) {
		Iao.deleteAirport(airportCode);
	}
	@Override
	public List<Airport> listAirport() {
		return Iao.listAirport();
	}
	@Override
	public void saveAirport(Airport airport) {
		Iao.saveAirport(airport); 
	}
	@Override
	public void updateAirport(Airport airport) {
		Iao.updateAirport(airport);;
	}
	@Override
	public Airport getAirport(String airportCode) {
		return Iao.getAirport(airportCode);
	}

}
