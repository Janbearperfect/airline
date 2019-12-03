package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.PersonalTicketDao;
import airsystem.entity.Flight;
import airsystem.entity.QueryFlight;
import airsystem.service.prototype.PersonalTicketService;
@Service
public class PersonalTicketServiceImpl implements PersonalTicketService {
	@Autowired
	private PersonalTicketDao ptd;
	@Override
	public List<QueryFlight> returnChooseTicket(String fromCity, String toCity, String startDate) {
		return ptd.returnChooseTicket(fromCity, toCity, startDate);
	}

	@Override
	public void changeTicket(String flightNumber, int classes, double price, int ticketId) {
		ptd.changeTicket(flightNumber, classes, price, ticketId);
	}

	@Override
	public Flight getPrice(String flightId,int classes) {
		Flight flight=ptd.getPrice(flightId);
		if(classes==1) {
			flight.setPrice(flight.getPrice()*flight.getSeasonDiscount()*2);
		}else if(classes==2) {
			flight.setPrice(flight.getPrice()*flight.getSeasonDiscount()*1.5);
		}else if(classes==3) {
			flight.setPrice(flight.getPrice()*flight.getSeasonDiscount()*1);
		}
		return flight;
	}

}
