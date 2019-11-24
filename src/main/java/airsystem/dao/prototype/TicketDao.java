package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;


/*
 * 票务管理dao层接口
 * */

public interface TicketDao {
  List<TicketBo> listTicket();
  int countTicketTotal();
  List<TicketBo> listTicketChange();
  int countTicketChangeTotal();
  List<TicketBo> listTicketRefund();
  int countTicketRefundTotal();
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
