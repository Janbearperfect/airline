package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.QueryFlight;

/**
 * 查询航班
 * @author 赵胜涛
 *
 */

public interface QueryFlightService {
	List<QueryFlight> listqueryFlight(String fromCity,String toCity,String startDate);
	
	QueryFlight getQueryFlight(int id);
}
