package airsystem.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.PersonalTicketManageDao;
@Repository
public class PersonalTicketManageDaoImpl implements PersonalTicketManageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean presonalReturnTicket(int id) {
		int num = jdbcTemplate.update("update ticket_order set status=3 where id=?",new Object[] {id});
		if(num>0) {
			return true;
		}else {
			return false;
		}
		
	}
}
