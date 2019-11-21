package airsystem.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.PersonalTicketDao;
import airsystem.entity.Ticket;
@Repository
public class PersonalTicketDaoImpl implements PersonalTicketDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void returnTicket(Ticket ticket) {
		jdbcTemplate.update("update ticket_order set status=3 where id=?",new Object[] {ticket.getId()});
	}

	@Override
	public void changeTicket(Ticket ticket) {
		jdbcTemplate.update("update ticket_order set status=2,flight_id=? where id=?",new Object[] {ticket.getId()});
	}
}
