package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.TicketDao;
import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;
import airsystem.service.prototype.TicketService;

/*
 * 票务管理service层实现
 * */
@Service
public class TicketServiceImpl implements TicketService{
    
	@Autowired
	private TicketDao ticketDao;
	@Override
	public List<TicketBo> listPaged() {
		return ticketDao.listTicket();
		

		
	}
	@Override
	public List<TicketBo> listPagedChange() {
		
		return ticketDao.listTicketChange();
	}
	@Override
	public List<TicketBo> listPagedRefund() {
		// TODO Auto-generated method stub
		return ticketDao.listTicketRefund();
	}
	@Override
	public int countTicket() {
		
		return ticketDao.countTicketTotal();
	}
	@Override
	public int countTicketChange() {
		
		return ticketDao.countTicketChangeTotal();
	}
	@Override
	public int countTicketRefund() {
		return ticketDao.countTicketRefundTotal();
	}

	@Override
	public boolean saveTicket(Ticket ticket) {
		if(ticketDao.saveTicket(ticket)) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<Ticket> searchSelfAllTicket(int userId) {
		return ticketDao.searchSelfAllTicket(userId);
	}
	@Override
	public List<Ticket> searchSelfChangeTicket(int userId) {
		return ticketDao.searchSelfChangeTicket(userId);
	}
	@Override
	public List<Ticket> searchSelfRefundTicket(int userId) {
		return ticketDao.searchSelfRefundTicket(userId);
	}
	@Override
	public List<TicketBo> listTicket(int branchId) {
		// TODO Auto-generated method stub
		return ticketDao.listTicket(branchId);
	}
	@Override
	public int countTicketTotal(int branchId) {
		// TODO Auto-generated method stub
		return ticketDao.countTicketTotal(branchId);
	}
	@Override
	public List<TicketBo> listTicketChange(int branchId) {
		// TODO Auto-generated method stub
		return ticketDao.listTicketChange(branchId);
	}
	@Override
	public int countTicketChangeTotal(int branchId) {
		// TODO Auto-generated method stub
		return ticketDao.countTicketChangeTotal(branchId);
	}
	@Override
	public List<TicketBo> listTicketRefund(int branchId) {
		// TODO Auto-generated method stub
		return ticketDao.listTicketRefund(branchId);
	}
	@Override
	public int countTicketRefundTotal(int branchId) {
		// TODO Auto-generated method stub
		return ticketDao.countTicketRefundTotal(branchId);
	}


}
