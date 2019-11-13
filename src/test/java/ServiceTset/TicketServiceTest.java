package ServiceTset;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;
import airsystem.service.prototype.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TicketServiceTest {
   
	@Autowired
	private TicketService ticketService;
	
	@Test
	public void test() {
		List<TicketBo> list=ticketService.listPaged();
		for (TicketBo ticket : list) {
			System.out.println(ticket);
		}		
	}
	
	@Test
	public void test1() {
		List<TicketBo> list=ticketService.listPagedChange();
		for (TicketBo ticket : list) {
			System.out.println(ticket.toString());
		}
	}
	@Test
	public void test2() {
		List<TicketBo> list=ticketService.listPagedRefund();
		for (TicketBo ticket : list) {
			System.out.println(ticket.toString());
		}
	}
	
	@Test
	public void test3() {
		System.out.println(ticketService.countTicketRefund());
	}
	@Test
	public void test4() {
		List<Ticket> list=ticketService.searchSelfAllTicket(0);
		for (Ticket ticket : list) {
			System.out.println(ticket);
		}
	}
	@Test
	public void test5() {
		List<Ticket> list=ticketService.searchSelfChangeTicket(0);
		for (Ticket ticket : list) {
			System.out.println(ticket);
		}
	}
	@Test
	public void test6() {
		List<Ticket> list=ticketService.searchSelfRefundTicket(0);
		for (Ticket ticket : list) {
			System.out.println(ticket);
		}
	}
	
}
