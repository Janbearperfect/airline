package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.FlightSchedulerDao;
import airsystem.entity.FlightScheduler;

/**
 * ∫Ωø’º∆ªÆ±Ì≤‚ ‘
 * @author ’‘ §ÃŒ
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightSchedulerDaoImplTest {
	@Autowired
	private FlightSchedulerDao fs;
	
	@Test
	public void findTest() {
		System.out.println(fs.getFlightScheduler("zst02"));
		
	}
	@Test
	public void findIdTest() {
		System.out.println(fs.getFlightScheduler(1));
	}
	@Test
	public void updateTest() {
		System.out.println(fs.updateString(1, "from_city", "CHZ"));
	}
	@Test
	public void deleteTest() {
		System.out.println(fs.deleteFlightScheduler("zst03"));
	}
	@Test 
	public void saveTest() {
		System.out.println(fs.saveFlightScheduler("zst02","2019-11-06", "2019-11-6", "TYZ", "YCH", "2019-11-06 08-00-00", "2019-11-06 12-00-00", "10002", "2", 800));
	}
	@Test
	public void findAllTest() {
		List<FlightScheduler> list=fs.listFlightScheduler();
		for(FlightScheduler fsr:list) {
			System.out.println(fsr);
		}
	}
	@Test
	public void findTimeTest() {
		List<FlightScheduler> list=fs.listTimeFlightScheduler("2019-11-08");
		for(FlightScheduler fsr:list) {
			System.out.println(fsr);
		}
	}
}
