package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.User;

public interface UsersDao {
    List<User> listUser();
    int countUserTotal();
}
