package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.AirplaneModel;

public interface AirplaneModelService {
	
	List<AirplaneModel> listAirplaneModel(int pageNum,int pageSize);
	
	List<AirplaneModel> findAll();

	
    AirplaneModel getAirportModel(String airplane);
	
	void saveOrUpdate(AirplaneModel am); 
	
	void deleteAirportModel(String airplane);
	
	int totalItem();
}
