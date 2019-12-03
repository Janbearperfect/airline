package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.Flight;
import airsystem.entity.QueryFlight;

public interface PersonalTicketDao {
	List<QueryFlight> returnChooseTicket(String fromCity, String toCity, String startDate);
	void changeTicket(String flightNumber,int classes,double price,int ticketId);
	Flight getPrice(String flightId);
}





