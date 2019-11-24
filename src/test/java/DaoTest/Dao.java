package DaoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.SalesDao;

//dao层测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class Dao {
		@Autowired
		private SalesDao sd;
	  @Test
	    public void test01() {
	    	System.out.println(sd.getSaleflightId("18"));
	    }
}
