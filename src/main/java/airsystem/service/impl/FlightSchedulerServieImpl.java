package airsystem.service.impl;


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
//	@Override
//	public List<FlightScheduler> listNowFlightScheduler() {
//		List<FlightScheduler> list = fsd.listFlightScheduler();
//		List<FlightScheduler> flightScheduler;
//		Date day=new Date();    
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		String date=df.format(day);    
//		for(int i=0;i<list.size();i++) {
//			
//		 
//		}
//		
//		return null;
//	}

//	@Override
//	public List<FlightScheduler> listOutFlightScheduler() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String saveFlightScheduler(String flightNumber, String startString, String endString, String fromCity,
			String toCity, String departureTime, String arrivalTime, String airplane, String scheduler,
			int sailLength) {
		
		return fsd.saveFlightScheduler(flightNumber, startString, endString, fromCity, toCity, departureTime, arrivalTime, airplane, scheduler, sailLength);
	}

	@Override
	public String deleteFlightScheduler(String flightNumber) {
		
		return fsd.deleteFlightScheduler(flightNumber);
	}

	@Override
	public String updateString(int id, String index, String values) {
		
		return fsd.updateString(id, index, values);
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

}
