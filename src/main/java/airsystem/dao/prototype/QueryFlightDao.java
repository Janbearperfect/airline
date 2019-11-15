package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.PersonalTicket;
import airsystem.entity.QueryFlight;

/**
 * 查询航班
 * @author 赵胜涛
 *
 */
public interface QueryFlightDao {
	 List<QueryFlight> listQueryFlight(String fromCity, String toCity,String startDate);  
	 
	 String getPersonalInfo(String IDNumber);   //判断身份证号是否正确
	 
	 List<PersonalTicket> listPersonalFutureTicket(String IDNumber);  //根据证件号码查未出行票务信息
	
	 List<PersonalTicket> listPersonalBeforeTicket(String IDNumber);  //根据证件号码查已出行票务信息
	 
	 List<PersonalTicket> listPersonalFutureTicketId(int userId);  //根据用户id查未出行票务信息
	 
	 List<PersonalTicket> listPersonalBeforeTicketId(int userId);  //根据用户id查已出行票务信息
	 }
