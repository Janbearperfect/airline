package airsystem.dao.prototype;

import airsystem.entity.Ticket;

public interface PersonalTicketDao {
	void returnTicket(Ticket ticket);
	void changeTicket(Ticket ticket);
}





