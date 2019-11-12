package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.QueryFlightDao;
import airsystem.entity.QueryFlight;
import airsystem.service.prototype.QueryFlightService;

/**
 * ��ѯ����ʵ����
 * @author ��ʤ��
 *
 */
@Service
public class QueryFlightServiceImpl implements QueryFlightService{
	@Autowired
	QueryFlightDao qfd;

	@Override
	public List<QueryFlight> listqueryFlight(String fromCity, String toCity, String startDate) {
		System.out.println("2222");
		return qfd.listQueryFlight(fromCity, toCity, startDate);
	}

	@Override
	public QueryFlight getQueryFlight(int id) {
		
		return qfd.getQueryFlight(id);
	}
}
