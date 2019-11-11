package airsystem.dao.prototype;


import java.util.ArrayList;
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
	
	FlightScheduler getFlightScheduler(int id); //根据航班id查询
	
	FlightScheduler getFlightScheduler(String number); //根据航班编号查询
	
	List<FlightScheduler> listTimeFlightScheduler(String date);//根据时间查询
	
	//查询实时航班
	List<FlightScheduler> listNowFlightDao();
	//查询往期航班
	List<FlightScheduler> listOutFlightDao();
	
	String deleteFlightScheduler(int id);//删除
	
	String updateString(int id,String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength); //更新
	
	
	
	String saveFlightScheduler(String flightNumber,String startString,String endString,String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength); //插入
	
	int totalItems();    // 总条数
	//分页查询
	List<FlightScheduler> listFind(int offset,int pageSize);
	//
	Pager<FlightScheduler> listPage(int offset,int pageSize);
}
