package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.Flight;

public interface FlightService {
	void updateFlight(double seasonDiscount,double price,int flightId);
	Flight getFlight(int flightId); //根据航班id查询
	Flight getFlight(String flightNumber); //航班编号
	List<Flight> listFlight(); //所有的航班查询
	int totalItems();    // 总条数
	void updateFlightSeat(int flightId,int classes,int num);
	int searchFlightId(String flightNumber);
}
