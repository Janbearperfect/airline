package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.AirportDao;
import airsystem.entity.Airport;
@Repository
public class AirportDaoImpl implements AirportDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void deleteAirport(String airportCode) {
		jdbcTemplate.update("delete from airport where airport_code=?", new Object[] {airportCode});
		System.out.println("删除成功");
	}
	@Override
	public List<Airport> listAirport() {
		return jdbcTemplate.query("select * from airport", new BeanPropertyRowMapper<Airport>(Airport.class));
	}
	@Override
	public void saveAirport(Airport airport) {
		//		if(airport.getAirportCode()==null) {
		jdbcTemplate.update("insert into airport(airport_code,city,airport_name) values(?,?,?)", new Object[] {airport.getAirportCode(),airport.getCity(),airport.getAirportName()});
		//		}else {
		//			jdbcTemplate.update("update from airport set airport_code=? city=? airport_name=? where airport=?",new Object[] {airport.getAirportCode(),airport.getCity(),airport.getAirportName(),airport.getAirportCode()});
		//		}
	}
	@Override
	public Airport getAirport(String airportCode) {
		return jdbcTemplate.queryForObject("select * from airport where airport_code=?", new Object[] {airportCode},new BeanPropertyRowMapper<Airport>(Airport.class));
	}
	@Override
	public void updateAirport(String airportCode,String city,String airportName) {
		jdbcTemplate.update("update airport set airport_code=?,city=?,airport_name=? where airport_code=?",new Object[] {airportCode,city,airportName,airportCode});
	}
}
