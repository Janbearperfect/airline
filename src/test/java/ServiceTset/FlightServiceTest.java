package ServiceTset;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.entity.Flight;
import airsystem.service.prototype.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightServiceTest {
     
	@Autowired
	private FlightService f;
	
	@Test
	public void test() {
		System.out.println(f.totalItems());
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
		f.updateFlight(1.5,454,2);
	}
	
	@Test
	public void test3() {
		Flight flight=f.getFlight(1);
		System.out.println(flight);
	}
}
