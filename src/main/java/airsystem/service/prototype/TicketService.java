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
	boolean saveTicket(Ticket ticket);
	List<Ticket> searchSelfAllTicket(int userId);
	List<Ticket> searchSelfChangeTicket(int userId);
	List<Ticket> searchSelfRefundTicket(int userId);
	  List<TicketBo> listTicket(int branchId);
	  int countTicketTotal(int branchId);
	  List<TicketBo> listTicketChange(int branchId);
	  int countTicketChangeTotal(int branchId);
	  List<TicketBo> listTicketRefund(int branchId);
	  int countTicketRefundTotal(int branchId);
	  
	  
}
