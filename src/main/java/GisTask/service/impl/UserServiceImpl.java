package GisTask.service.impl;

import GisTask.dao.UserDao;
import GisTask.dao.impl.UserDaoImpl;
import GisTask.domain.User;
import GisTask.service.UserService;

/**
 * @author Jayce
 * @date 2019/10/14
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(User loginUser) {
        return dao.login(loginUser);
    }

    @Override
    public int register(User registerUser) {
        return dao.register(registerUser);
    }

    @Override
    public boolean findUserByName(String name) {
        return dao.findUserByName(name);
    }
}
