package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.FlightScheduler;

/**
 * 航班计划表
 * @author 赵胜涛
 *
 */
public interface FlightSchedulerService {
//	//
//	List<FlightScheduler> listNowFlightScheduler();
	//��ѯ���к���ƻ�
	List<FlightScheduler> listFlightSchedulerService();
//	//��ѯ���ں���
//	List<FlightScheduler> listOutFlightScheduler();
	
	//添加
	String saveFlightScheduler(String flightNumber,String startString,String endString,String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength);
	//删除
	String deleteFlightScheduler(String flightNumber);
	
	//更新
	String updateString(int id,String index,String values); //����ĳЩ�ֶ�
	
	//总条数
	int totalItems(); 
	
	
}
