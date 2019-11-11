package airsystem.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.FlightSchedulerDao;
import airsystem.entity.Flight;
import airsystem.entity.FlightScheduler;
import airsystem.util.Pager;


/**
 * 航空计划表的实现实现类
 * @author 赵胜涛
 *
 */
@Repository("flightSchedulerDaoImpl")
public class FlightSchdulerDaoImpl implements FlightSchedulerDao{
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public List<FlightScheduler> listFlightScheduler() {
		return jdbctemplate.query("select * from flight_scheduler", new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}
	
	
	@Override
	public String deleteFlightScheduler(String flightNumber) {
		int success=jdbctemplate.update("delete from flight_scheduler where flight_number=?",new Object[] {flightNumber});
		if(success!=0) {
			return "success";
		}else {
		return "failure";
		}
	}

	@Override
	public String saveFlightScheduler(String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength) {
		
		int success= jdbctemplate.update("insert into flight_scheduler(flight_number,start_date,end_date,from_city,to_city,departure_time,arrival_time,airplane,scheduler,sail_length) values(?,?,?,?,?,?,?,?,?,?)",new Object[] {flightNumber,startDate,endDate,fromCity,toCity,departureTime,arrivalTime,airplane,scheduler,sailLength});
		if(success!=0) {
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

	@Override
	public Pager<FlightScheduler> listPage(int offset, int pageSize) {
		Pager<FlightScheduler> pager = new Pager<FlightScheduler>();
		pager.setData(listFind(offset,pageSize));
		return pager;
	}

	@Override
	public String updateString(int id,String index, String values) {
		int success=jdbctemplate.update("update flight_scheduler set ?=?  where id=? ",new Object[] {index,values,id});
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
		return jdbctemplate.queryForObject("select * from flight_scheduler where id=?", new Object[]{id}, new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}

	@Override
	public List<FlightScheduler> listTimeFlightScheduler(String startDate) {
		
		return jdbctemplate.query("select * from flight_scheduler where start_date=?", new Object[] {startDate},new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}
	
	
}
