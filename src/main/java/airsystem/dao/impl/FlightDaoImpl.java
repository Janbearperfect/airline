package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.FlightDao;
import airsystem.entity.Flight;


/**
 * 航班表实现类
 * @author 赵胜涛
 *
 */
@Repository("flightDaoImpl")
public class FlightDaoImpl implements FlightDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Flight getFlight(int flightId) {
		
		return jdbcTemplate.queryForObject("select * from flight where flight_id=?", new Object[]{flightId}, new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public Flight getFlight(String flightNumber) {
		
		return jdbcTemplate.queryForObject("select * from flight where flight_number=?", new Object[] {flightNumber},new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public List<Flight> listFlight() {
		
		return jdbcTemplate.query("select * from flight", new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public int totalItems() {
	
		return jdbcTemplate.queryForObject("select count(*) from flight",Integer.class);
	}

	@Override
	public String updateFlight(double seasonDiscount,double price,int flightId) {
		// TODO Auto-generated method stub
		
		int num= jdbcTemplate.update("update flight set season_discount=?,price=? where flight_id=?", 
				new Object[] {seasonDiscount,price,flightId});
		if(num>0) {
			return "success";
		}
		return "faliure";
		
	}

	


	
}
