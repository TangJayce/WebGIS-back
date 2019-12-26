package GisTask.dao;

import GisTask.domain.User;

/**
 * @author Jayce
 * @date 2019/10/13
 */
public interface UserDao {

    public User login(User loginUser);

    public int register(User registerUser);

    public boolean findUserByName(String name);
}
