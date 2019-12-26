package GisTask.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid连接池的工具类
 * @author Jayce
 * @date 2019/9/24
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }

    /**
     * 获取连接池对象
     * @return 连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }
}
