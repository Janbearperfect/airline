package ServiceTset;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.UsersDao;
import airsystem.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class UserServiceTest {
	@Autowired
	private UsersDao user;
	
	@Test
	public void test() {
		List<User> list=user.listUser();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void test1() {
		System.out.println(user.countUserTotal());
	}
}
