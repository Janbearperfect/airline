package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.QueryFlightDao;
import airsystem.entity.PersonalTicket;
import airsystem.entity.QueryFlight;
import airsystem.service.prototype.QueryFlightService;

/**
 * 查询航班信息
 * @author 赵胜涛
 *
 */
@Service
public class QueryFlightServiceImpl implements QueryFlightService{
	@Autowired
	QueryFlightDao qfd;

	@Override
	public List<QueryFlight> listqueryFlight(String fromCity, String toCity, String startDate) {
		return qfd.listQueryFlight(fromCity, toCity, startDate);
	}

	@Override
	public String getPersonalInfo(String IDNumber) {
		
		return qfd.getPersonalInfo(IDNumber);
	}

	@Override
	public List<PersonalTicket> listPersonalFutureTicket(String IDNumber) {
		
		return qfd.listPersonalFutureTicket(IDNumber);
	}

	@Override
	public List<PersonalTicket> listPersonalBeforeTicket(String IDNumber) {
		// TODO Auto-generated method stub
		return qfd.listPersonalBeforeTicket(IDNumber);
	}

	@Override
	public List<PersonalTicket> listPersonalFutureTicketId(int userId) {
		// TODO Auto-generated method stub
		return qfd.listPersonalFutureTicketId(userId);
	}

	@Override
	public List<PersonalTicket> listPersonalBeforeTicketId(int userId) {
		// TODO Auto-generated method stub
		return qfd.listPersonalBeforeTicketId(userId);
	}


	
}
