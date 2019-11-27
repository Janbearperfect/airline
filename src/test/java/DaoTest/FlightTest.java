package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;

import airsystem.config.TestConfig;
import airsystem.entity.Flight;
import airsystem.mapper.FlightMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightTest {
	    @Autowired
		private FlightMapper f;
	    @Test
	   public void test() {
	    	PageHelper.startPage(1, 3);
		   List<Flight> list=f.listFlight();
		   for (Flight flight : list) {
			System.out.println(flight);
		}
	   } 
	    
}
