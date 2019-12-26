package GisTask.dao.impl;

import GisTask.dao.UserDao;
import GisTask.domain.User;
import GisTask.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * @author Jayce
 * @date 2019/10/13
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return 包含用户的全部数据
     */
    @Override
    public User login(User loginUser) {
        try {
            String sql = "select * from user where name = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getName(), loginUser.getPassword());
            return user;
        }catch (DataAccessException e){
            //e.printStackTrace();//记录日志
            System.out.println("用户名或密码错误...");
            return null;
        }
    }

    @Override
    public int register(User registerUser) {
        try {
            String sql = "insert into user values(null,?,?)";
            int count = template.update(sql,
                    registerUser.getName(), registerUser.getPassword());
            return count;
        }catch (DataAccessException e){
            //e.printStackTrace();//记录日志
            System.out.println("注册失败...");
            return -1;
        }
    }

    @Override
    public boolean findUserByName(String name) {
        try {
            String sql = "select * from user where name = ?";
            Map<String, Object> map = template.queryForMap(sql, name);
            System.out.println("map = " + map);
            return true;
        }catch (DataAccessException e){
            //e.printStackTrace();//记录日志
            System.out.println("没有找到该用户...");
            return false;
        }
    }
}
