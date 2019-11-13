package DaoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airsystem.config.TestConfig;
import airsystem.dao.prototype.FinancialDao;
import airsystem.entity.FinancialClasses;
import airsystem.entity.FinancialType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FinancialTest {
	@Autowired
	private FinancialDao f;
	
	@Test
	public void test() {
		List<FinancialClasses> list=f.listFinancialClass();
		for (FinancialClasses financialClasses : list) {
			System.out.println(financialClasses);
		}
	}
	
	@Test
	public void test2() {
		List<FinancialType> list=f.listFinancialType();
		for (FinancialType financialType : list) {
			System.out.println(financialType);
		}
	}
	
	@Test
	public void test3() {
		System.out.println(f.financialTotal());
	}
}
