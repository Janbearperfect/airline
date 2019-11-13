package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.UsersDao;
import airsystem.entity.User;
import airsystem.service.prototype.UsersService;

@Service("usersserviceimpl")
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao userDao;

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userDao.listUser();
	}

	@Override
	public int countUserTotal() {
		// TODO Auto-generated method stub
		return userDao.countUserTotal();
	}

}
