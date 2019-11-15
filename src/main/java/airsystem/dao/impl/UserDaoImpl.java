package airsystem.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.UserDao;
import airsystem.entity.UserL;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public UserL findUser(String phone) {
		return JdbcTemplate.queryForObject("select * from user where phone =?", new Object[] {phone},
				new BeanPropertyRowMapper<UserL>(UserL.class));
	}

	@Override
	public void saveUser(UserL user) {
		JdbcTemplate.update("insert into user(phone,password,uname,sex,age,address) values(?,?,?,?,?,?)",
				new Object[] {user.getPhone(),user.getPassword(),user.getUname(),user.getSex(),user.getAge(),user.getAddress(),user.getId()});
		
	}

	@Override
	public int isHavePhone(String phone) {
		
		return JdbcTemplate.queryForObject("select count(*) from user where phone=?",new Object[] {phone},Integer.class);
	}

	@Override
	public void updateUser(UserL user) {
		JdbcTemplate.update("update user set uname=?,sex=?,age=?,address=? where id=?",
				new Object[] {user.getUname(),user.getSex(),user.getAge(),user.getAddress(),user.getId()});
		
	}

}