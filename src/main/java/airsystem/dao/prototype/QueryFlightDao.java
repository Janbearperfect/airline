package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.Airport;
import airsystem.entity.QueryFlight;

/**
 * 查询航班
 * @author 赵胜涛
 *
 */
public interface QueryFlightDao {
	 List<QueryFlight> listQueryFlight(String fromCity, String toCity,String startDate);  
	 
	 QueryFlight  getQueryFlight(int id);
	 }
