package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import airsystem.dao.prototype.UsersDao;
import airsystem.entity.User;

@Repository("usersdaoimpl")
public class UsersDaoImpl implements UsersDao{
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<User> listUser() {
		
		return jdbcTemplate.query("select * from user ",
				new Object[] {},new BeanPropertyRowMapper(User.class));
	}

	@Override
	public int countUserTotal() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from user", new Object[] {},Integer.class);
	}

}
