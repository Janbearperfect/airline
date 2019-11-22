package DaoTest;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.FlightSchedulerDao;

/**
 * ���ռƻ������
 * @author ��ʤ��
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FlightSchedulerDaoImplTest {
	@Autowired
	private FlightSchedulerDao fs;
	
	
	
}
