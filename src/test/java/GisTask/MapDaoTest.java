package GisTask;

import GisTask.dao.MapDao;
import GisTask.dao.impl.MapDaoImpl;
import org.junit.Test;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public class MapDaoTest {
    private MapDao dao = new MapDaoImpl();

    @Test
    public void findLayerByNameTest(){
        System.out.println(dao.findLayerByName("county","浏阳市"));
    }
    @Test
    public void findMBRByNameTest(){
        System.out.println(dao.findMBRByName("county","浏阳市"));
    }
    @Test
    public void selectLayersNameTest(){
        System.out.println(dao.selectLayersName("railway"));
    }
    @Test
    public void selectUserPointTest(){
        System.out.println(dao.selectUserPoint("小橘子").get(0));
    }
    @Test
    public void deletePointTest(){
        System.out.println(dao.deletePoint(6));
    }
    @Test
    public void savePointTest(){
        System.out.println(dao.savePoint("jayce",113.23,27.36,"插入数据成功","2019-10-10 21:23:45"));
    }
}
