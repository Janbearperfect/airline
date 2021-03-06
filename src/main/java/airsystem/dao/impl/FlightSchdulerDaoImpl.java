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

import airsystem.dao.prototype.AirplaneModelDao;
import airsystem.dao.prototype.FlightSchedulerDao;
import airsystem.entity.AirplaneModel;
import airsystem.entity.FlightScheduler;


/**
 * 航空计划表的实现实现类
 * @author 赵胜涛
 *
 */
@Repository("flightSchedulerDaoImpl")
public class FlightSchdulerDaoImpl implements FlightSchedulerDao{
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	AirplaneModelDao amd;
	@Override
	public List<FlightScheduler> listFlightScheduler() {
		return jdbctemplate.query("select * from flight_scheduler left join airport on flight_scheduler.from_city=airport.airport_code", new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}

	@Override
	public String deleteFlightScheduler(int id) {
		String flightNumber=jdbctemplate.queryForObject("select flight_number from flight_scheduler where id=?", new Object[] {id},java.lang.String.class);
		int success=jdbctemplate.update("delete from flight_scheduler where id=?",new Object[] {id});
		int fn=jdbctemplate.update("delete from flight where flight_number=?",new Object[] {flightNumber});
		if(success!=0&&fn!=0) {
			return "success";
		}else {
		return "failure";
		}
	}

	@Override
	public String saveFlightScheduler(String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength) {
		AirplaneModel am=amd.getAirportModel(airplane);
		
		int sf=jdbctemplate.update("insert into flight(flight_number,first_class_remain_seats,business_class_remain_seats,economy_class_remain_seats,season_discount,price) values(?,?,?,?,1,0)",new Object[] {flightNumber,am.getFirst_class_seats(),am.getBusiness_class_seats(),am.getEconomy_class_seats()});
		int success= jdbctemplate.update("insert into flight_scheduler(flight_number,start_date,end_date,from_city,to_city,departure_time,arrival_time,airplane,scheduler,sail_length) values(?,?,?,?,?,?,?,?,?,?)",new Object[] {flightNumber,startDate,endDate,fromCity,toCity,departureTime,arrivalTime,airplane,scheduler,sailLength});
		if(success!=0&& sf !=0) {
			return "success";
		}
		return "failure";
	}

	@Override
	public int totalItems() {
		return jdbctemplate.queryForObject("select * from flight_scheduler", Integer.class);
	}

	@Override
	public List<FlightScheduler> listFind(int offset, int pageSize) {
		
		return jdbctemplate.query("select * from flight_scheduler limit ?,?", new Object[] {offset,pageSize},new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}

/*	@Override
	public Pager<FlightScheduler> listPage(int offset, int pageSize) {
		Pager<FlightScheduler> pager = new Pager<FlightScheduler>();
		pager.setData(listFind(offset,pageSize));
		return pager;
	}*/

	@Override
	public String updateString(int id,String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength) {
		String number=jdbctemplate.queryForObject("select flight_number from flight_scheduler where id=?", new Object[] {id},java.lang.String.class);
		
		int success=jdbctemplate.update("update flight_scheduler set flight_number=?,start_date=?,end_date=?,from_city=?,to_city=?,departure_time=?,arrival_time=?,airplane=?,scheduler=?, sail_length=? where id=? ",new Object[] {flightNumber, startDate, endDate, fromCity, toCity,
				departureTime, arrivalTime, airplane, scheduler, sailLength,id});
		if(!number.equals(flightNumber)) {
			int flightId=jdbctemplate.queryForObject("select flight_id from flight where flight_number =?", new Object[] {number},Integer.class);
			int sc=jdbctemplate.update("update flight set flight_number=? where flight_id=?",new Object[] {flightNumber,flightId});
		}
		if(success!=0) {
			return "success";
		}
		return "failure";
	}

	@Override
	public FlightScheduler getFlightScheduler(String number) {
		
		return jdbctemplate.queryForObject("select * from flight_scheduler where flight_number=?", new Object[]{number}, new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}

	@Override
	public FlightScheduler getFlightScheduler(int id) {
		FlightScheduler list=jdbctemplate.queryForObject("select * from flight_scheduler where id= ? ", new Object[]{id}, new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
		list.setToAirport(jdbctemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {list.getToCity()},java.lang.String.class));
		list.setAirportName((String)jdbctemplate.queryForObject("select airport_name from airport where airport_code=?", new Object[] {list.getFromCity()},java.lang.String.class));
		return list ;
	}
 
	@Override
	public List<FlightScheduler> listTimeFlightScheduler(String startDate) {
		
		return jdbctemplate.query("select * from flight_scheduler where start_date=?", new Object[] {startDate},new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}

@Override
	public List<FlightScheduler> listNowFlightDao() {
		List<FlightScheduler> flight=new ArrayList();
		List<FlightScheduler> list=jdbctemplate.query("select * from flight_scheduler left join airport on flight_scheduler.from_city=airport.airport_code", new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
		for (FlightScheduler  time: list) {
		
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String dateString = formatter.format(time.getDepartureTime());
		    Date date = null;
			try {
				date = formatter.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long date2=System.currentTimeMillis();
			long ts = date.getTime();
			if(date2<ts) {
				flight.add(time);
			}
			 
		}
		return flight;
	}

	@Override
	public List<FlightScheduler> listOutFlightDao() {
		List<FlightScheduler> flight=new ArrayList();
		List<FlightScheduler> list=jdbctemplate.query("select * from flight_scheduler left join airport on flight_scheduler.from_city=airport.airport_code", new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
		for (FlightScheduler  time: list) {
		
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String dateString = formatter.format(time.getDepartureTime());
		    Date date = null;
			try {
				date = formatter.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long date2=System.currentTimeMillis();
			long ts = date.getTime();
			if(date2>ts) {
				flight.add(time);
			}	 
		}
		return flight;
		
		
	}

	




}

	
	
