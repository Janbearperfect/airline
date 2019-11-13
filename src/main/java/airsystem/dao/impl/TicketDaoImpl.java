package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.TicketDao;
import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;

/*
 * 票务管理dao层实现
 * */
@Repository("ticketdaoimpl")
public class TicketDaoImpl implements TicketDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TicketBo> listTicket() {
		
		return jdbcTemplate.query("select flight_number,name,order_date,classes,passenger_type,sales_id,t_price FROM ticket_order LEFT JOIN flight ON ticket_order.flight_id=flight.flight_id LEFT JOIN user ON user.id=ticket_order.user_id WHERE status=1 or status=2 "
				,new Object[] {},
				new BeanPropertyRowMapper<TicketBo>(TicketBo.class));
	}

	@Override
	public List<TicketBo> listTicketChange() {
		
		return jdbcTemplate.query("select flight_number,name,order_date,classes,passenger_type,sales_id,t_price FROM ticket_order LEFT JOIN flight ON ticket_order.flight_id=flight.flight_id LEFT JOIN user ON user.id=ticket_order.user_id WHERE status=2 ;",
				
				new Object[] {},new BeanPropertyRowMapper<TicketBo>(TicketBo.class));
	}

	@Override
	public List<TicketBo> listTicketRefund() {
       return jdbcTemplate.query("select flight_number,name,order_date,classes,passenger_type,sales_id,t_price FROM ticket_order LEFT JOIN flight ON ticket_order.flight_id=flight.flight_id LEFT JOIN user ON user.id=ticket_order.user_id WHERE  status=3  ",
				
				new Object[] {},new BeanPropertyRowMapper<TicketBo>(TicketBo.class));
	}

	@Override
	public int countTicketTotal() {
		
		return jdbcTemplate.queryForObject("select count(*)  from ticket_order WHERE status=1 or status=2",
				new Object[] {},Integer.class);
	}

	@Override
	public int countTicketChangeTotal() {
		return jdbcTemplate.queryForObject("select count(*)  from ticket_order WHERE status=2",
				new Object[] {},Integer.class);
	}

	@Override
	public int countTicketRefundTotal() {
		return jdbcTemplate.queryForObject("select count(*)  from ticket_order WHERE status=3",
				new Object[] {},Integer.class);
	}

	@Override
	public boolean saveTicket(Ticket ticket) {
		int num = jdbcTemplate.update("insert into ticket_order(user_id,flight_id,ID_number,classes,passenger_type,sales_id,status,t_price) values(?,?,?,?,?,?,?,?)",
				new Object[] {ticket.getUserId(),ticket.getFlightId(),ticket.getIdNumber(),ticket.getClasses(),ticket.getpassengerType(),ticket.getSalesId(),ticket.getStatus(),ticket.gettPrice()});
		if(num>0) {
			return true;
		}else {
			return false;
		}
	}

}
