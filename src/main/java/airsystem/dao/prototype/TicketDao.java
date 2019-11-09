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
}
