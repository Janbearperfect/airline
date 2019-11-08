package DaoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.FlightDao;


/**
 * ∫Ω∞‡±Ì≤‚ ‘
 * @author ’‘ §ÃŒ
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightDaoImplTest {
	@Autowired
	private FlightDao f;
	
	@Test
	public void getFlightTest() {
		System.out.println(f.getFlight(100));
	}
	@Test
	public void getFlightTest2() {
		System.out.println(f.getFlight("zst01"));
	}
}
