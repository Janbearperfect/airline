package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.FinancialDao;
import airsystem.entity.FinancialClasses;
import airsystem.entity.FinancialType;

@Repository("financial")
public class FinancialDaoImpl implements FinancialDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<FinancialClasses> listFinancialClass() {
	
		return jdbcTemplate.query("SELECT classes AS classes,SUM(t_price) AS price FROM ticket_order   where  to_days(order_date) = to_days(now()) and `status`=1 or TO_DAYS(order_date)=TO_DAYS(NOW()) and`status`=2 GROUP BY classes", 
				new Object[] {},new BeanPropertyRowMapper(FinancialClasses.class));
	}

	@Override
	public List<FinancialType> listFinancialType() {
		
		return jdbcTemplate.query("SELECT  passenger_type AS type, SUM(t_price) AS price FROM ticket_order where  to_days(order_date) = to_days(now()) and `status`=1 or TO_DAYS(order_date)=TO_DAYS(NOW()) and `status`=2  GROUP BY passenger_type", 
				new Object[] {},new BeanPropertyRowMapper(FinancialType.class));
	}

	@Override
	public double financialTotal() {
	
		return jdbcTemplate.queryForObject("SELECT SUM(t_price) AS tprice FROM ticket_order where  to_days(order_date) = to_days(now()) and `status`=1 or TO_DAYS(order_date)=TO_DAYS(NOW()) and `status`=2", 
				new Object[] {},Integer.class);
	}

	@Override
	public List<FinancialClasses> listFinancialClassQuarter() {
		
		return jdbcTemplate.query("SELECT classes AS classes,SUM(t_price) AS price FROM ticket_order   where  QUARTER(order_date)=QUARTER(now()) and YEAR(order_date)=Year(now()) and `status`=1 or  YEAR(order_date)=Year(now()) AND QUARTER(order_date)=QUARTER(now())  and`status`=2 GROUP BY classes;\r\n" + 
				"", new Object[] {},new BeanPropertyRowMapper(FinancialClasses.class));
	}

	@Override
	public List<FinancialType> listFinancialTypeQuarter() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT passenger_type AS type,SUM(t_price) AS price FROM ticket_order   where  QUARTER(order_date)=QUARTER(now()) and YEAR(order_date)=Year(now()) and `status`=1 or  YEAR(order_date)=Year(now()) AND QUARTER(order_date)=QUARTER(now())  and`status`=2 GROUP BY passenger_type;\r\n" + 
				"", new Object[] {},new BeanPropertyRowMapper(FinancialType.class));
	}

	@Override
	public double financialQuarterTotal() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT SUM(t_price) AS tprice FROM ticket_order where QUARTER(order_date)=QUARTER(now()) and YEAR(order_date)=Year(now()) and `status`=1 or QUARTER(order_date)=QUARTER(now()) and YEAR(order_date)=Year(now()) and `status`=2;\r\n" + 
				"", new Object[] {},Integer.class);
	}

	@Override
	public List<FinancialClasses> listFinancialClassYear() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT classes AS classes,SUM(t_price) AS price FROM ticket_order   where  YEAR(order_date)=Year(now()) and `status`=1 or Year(order_date)=Year(now())  and`status`=2 GROUP BY classes;\r\n" + 
				"", new Object[] {},new BeanPropertyRowMapper(FinancialClasses.class));
	}

	@Override
	public List<FinancialType> listFinancialTypeYear() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT passenger_type AS type,SUM(t_price) AS price FROM ticket_order  where  YEAR(order_date)=Year(now()) and `status`=1 or Year(order_date)=Year(now())  and`status`=2 GROUP BY passenger_type;\r\n" + 
				"", new Object[] {},new BeanPropertyRowMapper(FinancialType.class));
	}

	@Override
	public double financialYearTotal() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT SUM(t_price) AS tprice FROM ticket_order where  YEAR(order_date)=Year(now()) and `status`=1 or  YEAR(order_date)=Year(now()) and `status`=2;\r\n" + 
				"", new Object[] {},Integer.class);
	}
	



}
