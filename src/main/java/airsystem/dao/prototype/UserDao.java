package airsystem.dao.prototype;

import airsystem.entity.UserL;

public interface UserDao {
	UserL findUser(String phone);
	
	void saveUser(UserL user);
	
	int isHavePhone(String phone);
	
	void updateUser(UserL user);
}
