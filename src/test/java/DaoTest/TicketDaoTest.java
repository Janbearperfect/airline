package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.TicketDao;
import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TicketDaoTest {
	
    @Autowired
	private TicketDao tdao;
	
    @Test
    public void test(){
		List<TicketBo> list=tdao.listTicket();
		for (TicketBo ticket : list) {
			System.out.println(ticket.toString());
		}
    }
    
    @Test
    public void test1() {
    	List<TicketBo> list=tdao.listTicketChange();
    	for (TicketBo ticket : list) {
			System.out.println(ticket.toString());
		}
    }
    @Test
    public void test2() {
    	List<TicketBo> list=tdao.listTicketRefund();
    	for (TicketBo ticket : list) {
			System.out.println(ticket.toString());
		}   	
    }
    
    @Test
    public void test3() {
    	System.out.println(tdao.countTicketTotal());
    }
    @Test
    public void test4() {
    	Ticket ticket = new Ticket(1,1,"140525",2,3,1,120.0,1);
    	System.out.println(tdao.saveTicket(ticket));
    }
    @Test
    public void test5() {
    	List<Ticket> tickets = tdao.searchSelfAllTicket(0);
    	for (Ticket t : tickets) {
			System.out.println(t);
		}
    }
    @Test
    public void test6() {
    	List<Ticket> tickets = tdao.searchSelfChangeTicket(0);
    	for (Ticket t : tickets) {
			System.out.println(t);
		}
    }
    @Test
    public void test7() {
    	List<Ticket> tickets = tdao.searchSelfRefundTicket(0);
    	for (Ticket t : tickets) {
			System.out.println(t);
		}
    }
    
    @Test
    public void test8() {
    	List<TicketBo> list=tdao.listTicket(1);
    	for (TicketBo ticketBo : list) {
			System.out.println(ticketBo);
		}
    }
    
    @Test
    public void test9() {
    	List<TicketBo> list=tdao.listTicketChange(1);
    	for (TicketBo ticketBo : list) {
			System.out.println(ticketBo);
		}
    }
    
    @Test
    public void test10() {
    	List<TicketBo> list=tdao.listTicketRefund(1);
    	for (TicketBo ticketBo : list) {
    		System.out.println(ticketBo);
		}
    }
    @Test
    public void test11() {
    	System.out.println(tdao.countTicketTotal(1));
    }
    @Test
    public void test12() {
    	System.out.println(tdao.countTicketChangeTotal(1));
    }
    @Test
    public void test13() {
    	System.out.println(tdao.countTicketRefundTotal(1));
    }
}
