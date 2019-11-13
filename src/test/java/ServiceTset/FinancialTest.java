package ServiceTset;

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
import airsystem.service.prototype.FinancialService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class FinancialTest {
	
	@Autowired
	private FinancialService f;
	
	@Test
	public void test1() {
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
	
	@Test
	public void test4() {
		List<FinancialClasses> list=f.listFinancialClassQuarter();
		for (FinancialClasses financialClasses : list) {
			System.out.println(financialClasses);
		}
	}
	@Test
	public void test5() {
		List<FinancialType> list=f.listFinancialTypeQuarter();
		for (FinancialType financialType : list) {
			System.out.println(financialType);
		}
	}
	@Test
	public void test6() {
		System.out.println(f.financialQuarterTotal());
	}
	@Test
	public void test7() {
		List<FinancialClasses> list=f.listFinancialClassYear();
		for (FinancialClasses financialClasses : list) {
			System.out.println(financialClasses);
		}
	}
	@Test
	public void test8(){
		List<FinancialType> list=f.listFinancialTypeYear();
		for (FinancialType financialType : list) {
			System.out.println(financialType);
		}
	}
	@Test
	public void test9() {
		System.out.println(f.financialYearTotal());
	}
}
