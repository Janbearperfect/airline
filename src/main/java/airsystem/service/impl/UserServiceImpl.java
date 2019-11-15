package airsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.UserDao;
import airsystem.entity.UserL;
import airsystem.service.prototype.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public void saveUser(UserL user) {
		userDao.saveUser(user);
		
	}

	@Override
	public UserL findUser(String phone) {
		
		return userDao.findUser(phone);
	}

	@Override
	public int isHavePhone(String phone) {
		
		return userDao.isHavePhone(phone);
	}

	@Override
	public void updateUser(UserL user) {
		userDao.updateUser(user);
		
	}

}
