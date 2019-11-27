package airsystem.mapper;

import java.util.List;

import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;

public interface TicketMapper {
	List<TicketBo> listTickets();
	int countTickets();
	List<TicketBo> listTickets(TicketBo t);
	int countTickets(TicketBo t);
}
