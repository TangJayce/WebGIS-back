package GisTask.service;

import GisTask.domain.User;

/**
 * @author Jayce
 * @date 2019/10/14
 */
public interface UserService {
    public User login(User loginUser);

    public int register(User registerUser);

    public boolean findUserByName(String name);
}
