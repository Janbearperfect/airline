package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.AirplaneModelDao;
import airsystem.entity.AirplaneModel;
import airsystem.service.prototype.AirplaneModelService;

@Service
public class AirplaneModelServiceImpl implements AirplaneModelService{
	@Autowired
	private AirplaneModelDao amd;
	@Override
	public List<AirplaneModel> listAirplaneModel(int pageNum, int pageSize) {
		int totalItem=amd.totalItem();
		int num = (totalItem+pageSize-1)/pageSize;
		if(pageNum>num) {
			pageNum=num;
		}
		return amd.findAirportModel((pageNum-1)*pageSize, pageSize);
	}
	@Override
	public AirplaneModel getAirportModel(String airplane) {
		return amd.getAirportModel(airplane);
	}
	@Override
	public void Update(AirplaneModel am) {
		amd.Update(am);
		
	}
	
	@Override
	public void deleteAirportModel(String airplane) {
		amd.deleteAirportModel(airplane);
		
	}
	@Override
	public int totalItem() {
		return amd.totalItem();
		
	}
	@Override
	public List<AirplaneModel> findAll() {
		return amd.findAll();
		
	}
	@Override
	public void save(AirplaneModel am) {
		amd.save(am);
	}

}
