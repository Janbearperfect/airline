package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.Flight;
/**
 * 航空表接口
 * @author 赵胜涛
 *
 */
public interface FlightDao {
	Flight getFlight(int flightId); //根据航班id查询
	Flight getFlight(String flightNumber); //航班编号
//	List<Flight> listFlight(); //所有的航班查询
	int totalItems();    // 总条数
	
	String updateFlight(double seasonDiscount,double price,int flightId); //更新或者插入
	void updateFlightSeat(int flightId,int classes,int num);
	int searchFlightId(String flightNumber);
	List<Flight> listFlight();
}
