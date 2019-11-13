package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.User;

public interface UsersService {
    List<User> listUser();
    int countUserTotal();
}
