package ServiceTset;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;

import airsystem.entity.FlightScheduler;
import airsystem.service.prototype.FlightSchedulerService;

/**
 * ∫Ωø’º∆ªÆ±Ì
 * @author ’‘ §ÃŒ
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightSchedulerTest {

	@Autowired
	private FlightSchedulerService fs;
	
	@Test
	public void findTest() {
		List<FlightScheduler> list=fs.listFlightSchedulerService();
		for(FlightScheduler fssr:list) {
			System.out.println(fssr);
		}
	}
	@Test
	public void saveTest() {
		System.out.println(fs.saveFlightScheduler("zst08", "2019-10-02", "2019-10-02", "CHZ", "TYZ", "2019-10-01 13-30-00", "2019-10-01 15-00-00", "10001", "3", 200));		
	}
	@Test
	public void deleteTest() {
		System.out.println(fs.deleteFlightScheduler(14));
	}
	@Test
	public void updateTest() {
		System.out.println(fs.updateString(8, "scheduler", "5", null, null, null, null, null, null, null, 0));
	}
	@Test
	public void getTest() {
		System.out.println(fs.getFlightScheduler(1));
	}
	
}
