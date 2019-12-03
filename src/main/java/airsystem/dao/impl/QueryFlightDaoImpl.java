package airsystem.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.QueryFlightDao;
import airsystem.entity.PersonalTicket;
import airsystem.entity.QueryFlight;
/**
 * 航班信息
 * @author 赵胜涛
 *
 */
@Repository("queryFlightDaoImpl")
public class QueryFlightDaoImpl implements QueryFlightDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<QueryFlight> listQueryFlight(String fromCity, String toCity, String startDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		String from=jdbcTemplate.queryForObject("select airport_code from airport where city=?",new Object[] {fromCity},java.lang.String.class);
		String fcity=jdbcTemplate.queryForObject("select airport_name from airport where city=?",new Object[] {fromCity},java.lang.String.class);
		String tcity=jdbcTemplate.queryForObject("select airport_name from airport where city=?",new Object[] {toCity},java.lang.String.class);
		String to=jdbcTemplate.queryForObject("select airport_code from airport where city=?",new Object[] {toCity},java.lang.String.class);
		List<QueryFlight> flightScheduler=jdbcTemplate.query("select * from flight_scheduler where from_city=? and to_city=? and start_date=?", new Object[] {from,to,dateTime},new BeanPropertyRowMapper<QueryFlight>(QueryFlight.class));
		List<QueryFlight> query =new ArrayList<>();
		
		for(QueryFlight q:flightScheduler) {
			String flightNumber=q.getFlightNumber();
			String airplane=q.getAirplane();
			QueryFlight f=jdbcTemplate.queryForObject("select first_class_remain_seats,business_class_remain_seats,economy_class_remain_seats,\r\n" + 
					"season_discount,price from flight where flight_number=?", new Object[] {flightNumber},new BeanPropertyRowMapper<QueryFlight>(QueryFlight.class));
			int business=f.getBusinessClassRemainSeats();
			int first=f.getFirstClassRemainSeats();
			int economy=f.getEconomyClassRemainSeats();
			double season=f.getSeasonDiscount();
			double price=f.getPrice();
			QueryFlight m=jdbcTemplate.queryForObject("select model from airplane_model where airplane=?",new Object[] {airplane},new BeanPropertyRowMapper<QueryFlight>(QueryFlight.class));
			String model=m.getModel();
			q.setFromCity(fcity);
			q.setToCity(tcity);
			q.setModel(model);
			q.setBusinessClassRemainSeats(business);
			q.setEconomyClassRemainSeats(economy);
			q.setFirstClassRemainSeats(first);
			q.setPrice(price);
			q.setSeasonDiscount(season);
			query.add(q);
			
		}
		return query;
	}

	@Override
	public String getPersonalInfo(String IDNumber) {
		int count =jdbcTemplate.queryForObject("select count(*) from user_info where ID_number =?", new Object[] {IDNumber}, Integer.class);
		if(count!=0) {
			return "true";
		}
		return "false";
	}


	@Override
	public List<PersonalTicket> listPersonalFutureTicket(String IDNumber) {
		List<PersonalTicket> listTicket=new ArrayList<>();
		List<PersonalTicket>list= jdbcTemplate.query("select ticket_order.id,ticket_order.ID_number,flight.flight_number,user_info.name,ticket_order.order_date,ticket_order.classes,ticket_order.passenger_type,ticket_order.status,ticket_order.t_price,flight_scheduler.departure_time,flight_scheduler.arrival_time,flight_scheduler.sail_length,flight_scheduler.from_city,flight_scheduler.to_city from ticket_order left join user_info on ticket_order.ID_number=user_info.ID_number left join flight on ticket_order.flight_id=flight.flight_id left join flight_scheduler on flight.flight_number =flight_scheduler.flight_number where ticket_order.ID_number=? and NOW()<flight_scheduler.departure_time;", new Object[]{IDNumber},new BeanPropertyRowMapper<PersonalTicket>(PersonalTicket.class));
		for (PersonalTicket personalTicket : list) {
			if(personalTicket.getClasses().equals("1")) {
				personalTicket.setClasses("头等舱");
			}else if(personalTicket.getClasses().equals("2")) {
				personalTicket.setClasses("商务舱");
			}else if(personalTicket.getClasses().equals("3")) {
				personalTicket.setClasses("经济舱");
			}
			if(personalTicket.getPassengerType().equals("1")) {
				personalTicket.setPassengerType("成人票");
			}else if(personalTicket.getPassengerType().equals("2")) {
				personalTicket.setPassengerType("儿童票");
			}else if(personalTicket.getPassengerType().equals("3")) {
				personalTicket.setPassengerType("婴儿票");
			}
			if(personalTicket.getStatus().equals("1")) {
				personalTicket.setStatus("正常");
			}else if(personalTicket.getStatus().equals("2")) {
				personalTicket.setStatus("改签");
			}else if(personalTicket.getStatus().equals("3")) {
				personalTicket.setStatus("退票");
			}
				
			personalTicket.setFromCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getFromCity()},java.lang.String.class));
			personalTicket.setToCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getToCity()},java.lang.String.class));
			listTicket.add(personalTicket);
		}
		System.out.println(list);
		return listTicket;
	}

	@Override
	public List<PersonalTicket> listPersonalBeforeTicket(String IDNumber) {
		List<PersonalTicket> listTicket=new ArrayList<>();
		List<PersonalTicket>list=jdbcTemplate.query("select ticket_order.id,flight.flight_number,ticket_order.ID_number,user_info.name,ticket_order.order_date,ticket_order.classes,ticket_order.passenger_type,ticket_order.status,ticket_order.t_price,flight_scheduler.departure_time,flight_scheduler.arrival_time,flight_scheduler.sail_length,flight_scheduler.from_city,flight_scheduler.to_city from ticket_order left join user_info on ticket_order.ID_number=user_info.ID_number left join flight on ticket_order.flight_id=flight.flight_id left join flight_scheduler on flight.flight_number =flight_scheduler.flight_number where ticket_order.ID_number=? and NOW()>flight_scheduler.departure_time;", new Object[]{IDNumber},new BeanPropertyRowMapper<PersonalTicket>(PersonalTicket.class));
		 for (PersonalTicket personalTicket : list) {
				if(personalTicket.getClasses().equals("1")) {
					personalTicket.setClasses("头等舱");
				}else if(personalTicket.getClasses().equals("2")) {
					personalTicket.setClasses("商务舱");
				}else if(personalTicket.getClasses().equals("3")) {
					personalTicket.setClasses("经济舱");
				}
				if(personalTicket.getPassengerType().equals("1")) {
					personalTicket.setPassengerType("成人票");
				}else if(personalTicket.getPassengerType().equals("2")) {
					personalTicket.setPassengerType("儿童票");
				}else if(personalTicket.getPassengerType().equals("3")) {
					personalTicket.setPassengerType("婴儿票");
				}
				if(personalTicket.getStatus().equals("1")) {
					personalTicket.setStatus("正常");
				}else if(personalTicket.getStatus().equals("2")) {
					personalTicket.setStatus("改签");
				}else if(personalTicket.getStatus().equals("3")) {
					personalTicket.setStatus("退票");
				}
				personalTicket.setFromCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getFromCity()},java.lang.String.class));
				personalTicket.setToCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getToCity()},java.lang.String.class));
				listTicket.add(personalTicket);
			}
		 System.out.println(listTicket);
			return listTicket;
	}

	@Override
	public List<PersonalTicket> listPersonalFutureTicketId(int userId) {
		List<PersonalTicket> listTicket=new ArrayList<>();
		List<PersonalTicket>list=jdbcTemplate.query("select ticket_order.id,ticket_order.ID_number,flight.flight_number,user_info.name,ticket_order.order_date,ticket_order.classes,ticket_order.passenger_type,ticket_order.status,ticket_order.t_price,flight_scheduler.departure_time,flight_scheduler.arrival_time,flight_scheduler.sail_length,flight_scheduler.from_city,flight_scheduler.to_city from ticket_order left join user_info on ticket_order.ID_number=user_info.ID_number left join flight on ticket_order.flight_id=flight.flight_id left join flight_scheduler on flight.flight_number =flight_scheduler.flight_number where ticket_order.user_id=? and NOW()<flight_scheduler.departure_time;", new Object[]{userId},new BeanPropertyRowMapper<PersonalTicket>(PersonalTicket.class));
		 for (PersonalTicket personalTicket : list) {
			 if(personalTicket.getClasses().equals("1")) {
					personalTicket.setClasses("头等舱");
				}else if(personalTicket.getClasses().equals("2")) {
					personalTicket.setClasses("商务舱");
				}else if(personalTicket.getClasses().equals("3")) {
					personalTicket.setClasses("经济舱");
				}
				if(personalTicket.getPassengerType().equals("1")) {
					personalTicket.setPassengerType("成人票");
				}else if(personalTicket.getPassengerType().equals("2")) {
					personalTicket.setPassengerType("儿童票");
				}else if(personalTicket.getPassengerType().equals("3")) {
					personalTicket.setPassengerType("婴儿票");
				}
				if(personalTicket.getStatus().equals("1")) {
					personalTicket.setStatus("正常");
				}else if(personalTicket.getStatus().equals("2")) {
					personalTicket.setStatus("改签");
				}else if(personalTicket.getStatus().equals("3")) {
					personalTicket.setStatus("退票");
				}
				personalTicket.setFromCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getFromCity()},java.lang.String.class));
				personalTicket.setToCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getToCity()},java.lang.String.class));
				listTicket.add(personalTicket);
			}
		 
			return listTicket;
	}

	@Override
	public List<PersonalTicket> listPersonalBeforeTicketId(int userId) {
		List<PersonalTicket> listTicket=new ArrayList<>();
		List<PersonalTicket>list=jdbcTemplate.query("select ticket_order.id,ticket_order.ID_number,flight.flight_number,user_info.name,ticket_order.order_date,ticket_order.classes,ticket_order.passenger_type,ticket_order.status,ticket_order.t_price,flight_scheduler.departure_time,flight_scheduler.arrival_time,flight_scheduler.sail_length,flight_scheduler.from_city,flight_scheduler.to_city from ticket_order left join user_info on ticket_order.ID_number=user_info.ID_number left join flight on ticket_order.flight_id=flight.flight_id left join flight_scheduler on flight.flight_number =flight_scheduler.flight_number where ticket_order.user_id=? and NOW()>flight_scheduler.departure_time;", new Object[]{userId},new BeanPropertyRowMapper<PersonalTicket>(PersonalTicket.class));
		 for (PersonalTicket personalTicket : list) {
			 if(personalTicket.getClasses().equals("1")) {
					personalTicket.setClasses("头等舱");
				}else if(personalTicket.getClasses().equals("2")) {
					personalTicket.setClasses("商务舱");
				}else if(personalTicket.getClasses().equals("3")) {
					personalTicket.setClasses("经济舱");
				}
				if(personalTicket.getPassengerType().equals("1")) {
					personalTicket.setPassengerType("成人票");
				}else if(personalTicket.getPassengerType().equals("2")) {
					personalTicket.setPassengerType("儿童票");
				}else if(personalTicket.getPassengerType().equals("3")) {
					personalTicket.setPassengerType("婴儿票");
				}
				if(personalTicket.getStatus().equals("1")) {
					personalTicket.setStatus("正常");
				}else if(personalTicket.getStatus().equals("2")) {
					personalTicket.setStatus("改签");
				}else if(personalTicket.getStatus().equals("3")) {
					personalTicket.setStatus("退票");
				}
				personalTicket.setFromCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getFromCity()},java.lang.String.class));
				personalTicket.setToCity(jdbcTemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {personalTicket.getToCity()},java.lang.String.class));
				listTicket.add(personalTicket);
			}
			return listTicket;
	}


}
