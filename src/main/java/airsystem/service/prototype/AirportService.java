package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.Airport;

public interface AirportService {
	void deleteAirport(String airportCode);
	List<Airport> listAirport();
	void saveAirport(Airport airport);
	void updateAirport(Airport airport);
	Airport getAirport(String airportCode);
}
