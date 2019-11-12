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
import airsystem.entity.Airport;
import airsystem.entity.QueryFlight;
/**
 * 查询航班
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
	public QueryFlight getQueryFlight(int id) {
		
		return null;
	}

}
