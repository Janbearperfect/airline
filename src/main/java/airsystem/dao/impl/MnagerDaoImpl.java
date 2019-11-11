package airsystem.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.ManagerDao;
import airsystem.entity.Manager;

@Repository
public class MnagerDaoImpl implements ManagerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Manager findManager(String name) {
		return jdbcTemplate.queryForObject("select * from admin where number=?",new Object[] {name},new BeanPropertyRowMapper<Manager>(Manager.class));
		
	}

}
