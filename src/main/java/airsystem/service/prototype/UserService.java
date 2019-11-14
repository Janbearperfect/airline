package airsystem.service.prototype;

import airsystem.entity.UserL;

public interface UserService {
	void saveUser(UserL user);
	UserL findUser(String phone);
	int isHavePhone(String phone);
}
