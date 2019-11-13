package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.FinancialDao;
import airsystem.entity.FinancialClasses;
import airsystem.entity.FinancialType;
import airsystem.service.prototype.FinancialService;

@Service("financialservice")
public class FinancialServiceImpl implements FinancialService{
	
	@Autowired
	private FinancialDao financialDao;
	@Override
	public List<FinancialClasses> listFinancialClass() {
	
		return financialDao.listFinancialClass();
	}

	@Override
	public List<FinancialType> listFinancialType() {
	
		return financialDao.listFinancialType();
	}

	@Override
	public double financialTotal() {
		// TODO Auto-generated method stub
		return financialDao.financialTotal();
	}

	@Override
	public List<FinancialClasses> listFinancialClassQuarter() {
		
		return financialDao.listFinancialClassQuarter();
	}

	@Override
	public List<FinancialType> listFinancialTypeQuarter() {
		// TODO Auto-generated method stub
		return financialDao.listFinancialTypeQuarter();
	}

	@Override
	public double financialQuarterTotal() {
		// TODO Auto-generated method stub
		return financialDao.financialQuarterTotal();
	}

	@Override
	public List<FinancialClasses> listFinancialClassYear() {
		// TODO Auto-generated method stub
		return financialDao.listFinancialClassYear();
	}

	@Override
	public List<FinancialType> listFinancialTypeYear() {
		// TODO Auto-generated method stub
		return financialDao.listFinancialTypeYear();
	}

	@Override
	public double financialYearTotal() {
		// TODO Auto-generated method stub
		return financialDao.financialYearTotal();
	}

}
