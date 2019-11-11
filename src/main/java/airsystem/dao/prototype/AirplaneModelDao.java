package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.AirplaneModel;

public interface AirplaneModelDao {
	AirplaneModel getAirportModel(String airplane);
	
	List<AirplaneModel> findAirportModel(int offset,int pageSize);
	
	List<AirplaneModel> findAll();
	
	void Update(AirplaneModel am); 
	void save(AirplaneModel am); 
	
	void deleteAirportModel(String airplane);
	
	int totalItem();
}
