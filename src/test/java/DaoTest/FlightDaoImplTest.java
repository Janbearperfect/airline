package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.FlightDao;
import airsystem.entity.Flight;


/**
 * ��������
 * @author ��ʤ��
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightDaoImplTest {
	@Autowired
	private FlightDao f;
	
	@Test
	public void getFlightTest() {
		System.out.println(f.getFlight(1));
	}
	@Test
	public void getFlightTest2() {
		System.out.println(f.getFlight("zst01"));
	}
	
	@Test
	public void test1() {
		List<Flight> list=f.listFlight();
		for (Flight flight : list) {
			System.out.println(flight);
		}
	}
	
	@Test
	public void test2() {
		System.out.println(f.totalItems());
	}
	
	@Test
	public void test() {
	System.out.println(	f.updateFlight(1,645,1));
	}
	@Test
	public void test3() {
		f.updateFlightSeat(1, 3, 2);
	}
}
