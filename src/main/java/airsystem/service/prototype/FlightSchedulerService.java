package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.FlightScheduler;

/**
 * 航班计划表
 * @author 赵胜涛
 *
 */
public interface FlightSchedulerService {

	//查询全部航班
	List<FlightScheduler> listFlightSchedulerService();
	
	//添加
	String saveFlightScheduler(String flightNumber,String startString,String endString,String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength);
	//删除
	String deleteFlightScheduler(int id);
	
	//更新
	String updateString(int id,String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength); 
	//查看详细信息
	FlightScheduler getFlightScheduler(int id);
	//总条数
	int totalItems(); 
	
	//查询实时航班
	List<FlightScheduler> listNowFlightService();
	//查询往期航班
	List<FlightScheduler> listOutFlightService();
	
}
