package airsystem.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.FlightSchedulerDao;
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
		return null;
	}

	@Override
	public String deleteFlightScheduler(String flightNumber) {
		return null;
	}

	@Override
	public String updateFlightScheduler(String flightNumber, Date startDate, Date endDate, String fromCity,
			String toCity, Date departureTime, Date arrivalTime, String airplane, String scheduler, int sailLength) {
		
		return null;
	}

	@Override
	public String saveFlightScheduler(String flightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String airplane, String scheduler, int sailLength) {
		
		return null;
	}

	@Override
	public int totalItems() {
		return 0;
	}

	@Override
	public List<FlightScheduler> listFind(int offset, int pageSize) {
		
		return jdbctemplate.query("select * from account limit ?,?", new Object[] {offset,pageSize},new BeanPropertyRowMapper<FlightScheduler>(FlightScheduler.class));
	}

	@Override
	public Pager<FlightScheduler> listPage(int offset, int pageSize) {
		Pager<FlightScheduler> pager = new Pager<FlightScheduler>();
		pager.setData(listFind(offset,pageSize));
		return pager;
	}
	
	
}
