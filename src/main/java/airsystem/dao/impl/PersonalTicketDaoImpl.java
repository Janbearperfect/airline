package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.PersonalTicketDao;
import airsystem.entity.Flight;
import airsystem.entity.QueryFlight;
@Repository
public class PersonalTicketDaoImpl implements PersonalTicketDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<QueryFlight> returnChooseTicket(String fromCity, String toCity, String startDate) {
		return 
				jdbcTemplate.query("select ft.flight_id as id,airp.city as fromCity,air.city as toCity,fs.flight_number,am.model,fs.departure_time,fs.arrival_time,ft.first_class_remain_seats,ft.economy_class_remain_seats,ft.business_class_remain_seats,ft.season_discount,ft.price,fs.sail_length,fs.start_date,fs.end_date,am.airplane "
				+ "from flight_scheduler fs left join airport airp on fs.from_city=airp.airport_code left join airport air on fs.to_city=air.airport_code left join flight ft on ft.flight_number=fs.flight_number left join airplane_model am on am.airplane=fs.airplane "
				+ "where fs.from_city=(select airport_code from airport where airport_name=?) and fs.to_city=(select airport_code from airport where airport_name=?) and fs.start_date=?",new Object[] {fromCity,toCity,startDate},
				new BeanPropertyRowMapper<QueryFlight>(QueryFlight.class));
	}

	@Override
	public void changeTicket(String flightNumber,int classes,double price,int ticketId) {
		jdbcTemplate.update("update ticket_order set flight_id=(select flight_id from flight where flight_number=?),order_date=now(),classes=?,status=2,t_price=? where id=?",new Object[] {flightNumber,classes,price,ticketId});
	}

	@Override
	public Flight getPrice(String flightId) {
		
		return jdbcTemplate.queryForObject("select * from flight where flight_number=?", new Object[] {flightId},new BeanPropertyRowMapper<Flight>(Flight.class));
	}
}
