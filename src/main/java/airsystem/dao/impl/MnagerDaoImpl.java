package airsystem.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.ManagerDao;
import airsystem.entity.Branch;
import airsystem.entity.Manager;
import airsystem.entity.Sales;

@Repository
public class MnagerDaoImpl implements ManagerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Manager findManager(String name) {
		return jdbcTemplate.queryForObject("select * from admin where number=?",new Object[] {name},new BeanPropertyRowMapper<Manager>(Manager.class));
	}

	@Override
	public Sales findSale(String number) {
		return jdbcTemplate.queryForObject("select * from sales where number=?", new Object[] {number},new BeanPropertyRowMapper<Sales>(Sales.class));
	}

	@Override
	public Branch findBranch(String bnumber) {
		return jdbcTemplate.queryForObject("select * from branch where bnumber=?", new Object[] {bnumber}, new BeanPropertyRowMapper<Branch>(Branch.class));
	}

}
