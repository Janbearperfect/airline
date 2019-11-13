package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    
}
