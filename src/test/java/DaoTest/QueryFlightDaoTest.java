package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.QueryFlightDao;
import airsystem.entity.PersonalTicket;
import airsystem.entity.QueryFlight;

/**
 * 
 * @author ��ʤ��
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class QueryFlightDaoTest {
	@Autowired
	private QueryFlightDao qf;
	
	@Test
	public void query() {
		List<QueryFlight> list=qf.listQueryFlight("̫ԭ", "�˳�", "2019-11-06");
		for (QueryFlight queryFlight : list) {
			System.out.println(queryFlight);
		}
	}
	@Test
	public void listquert() {
		List<PersonalTicket> list=qf.listPersonalBeforeTicket("111222");
		for (PersonalTicket personalTicket : list) {
			System.out.println(personalTicket);
		}
	}

}
