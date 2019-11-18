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
		List<FinancialType> list=f.listFinancialType(1);
		for (FinancialType financialType : list) {
			System.out.println(financialType);
		}
	}
	
	@Test
	public void test3() {
		System.out.println(f.financialTotal(1));
	}
	@Test
	public void test4() {
		List<FinancialClasses> list=f.listFinancialClass(1);
		for (FinancialClasses financialClasses : list) {
			System.out.println(financialClasses);
		}		
	}
	@Test
	public void test5() {
		List<FinancialClasses> list=f.listFinancialClassQuarter(1);
		for (FinancialClasses financialClasses : list) {
			System.out.println(financialClasses);
		}
	}
	@Test
	public void Test6() {
		List<FinancialType> list=f.listFinancialTypeQuarter(1);
		for (FinancialType financialType : list) {
			System.out.println(financialType);
		}
	}
	@Test
	public void test7() {
		System.out.println(f.financialQuarterTotal(1));
	}
	@Test
	public void test8() {
		List<FinancialClasses> list=f.listFinancialClassYear(1);
		for (FinancialClasses financialClasses : list) {
			System.out.println(financialClasses);
		}
	}
	@Test
	public void test9() {
		List<FinancialType> list=f.listFinancialTypeYear(1);
		for (FinancialType financialType : list) {
			System.out.println(financialType);
		}
	}
	@Test
	public void test10() {
		System.out.println(f.financialYearTotal(1));
	}
}
