package airsystem.dao.prototype;

import java.util.Date;
import java.util.List;

import airsystem.entity.FlightScheduler;
import airsystem.util.Pager;

/**
 * 航空计划表接口
 * @author 赵胜涛
 *
 */

public interface FlightSchedulerDao{
	
	List<FlightScheduler> listFlightScheduler(); //查询所有航班计划
	String deleteFlightScheduler(String flightNumber);//删除
	String updateFlightScheduler(String flightNumber,Date startDate,Date endDate,String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String airplane, String scheduler, int sailLength);  //更新
	String saveFlightScheduler(String flightNumber,Date startDate,Date endDate,String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String airplane, String scheduler, int sailLength); //插入
	int totalItems();    // 总条数
	//分页查询
	List<FlightScheduler> listFind(int offset,int pageSize);
	//
	Pager<FlightScheduler> listPage(int offset,int pageSize);
}
