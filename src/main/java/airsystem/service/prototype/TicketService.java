package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;

/*
 * 票务管理service层接口
 * */

public interface TicketService {
	
	List<TicketBo> listPaged();
	
	
	List<TicketBo> listPagedChange();
	
	
	List<TicketBo> listPagedRefund();
	
	int countTicket();
	int countTicketChange();
	int countTicketRefund();
	
	
}
