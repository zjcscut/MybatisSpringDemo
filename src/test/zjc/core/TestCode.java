package zjc.core;

import cn.zjc.dao.AddressDAO;
import cn.zjc.dao.UserDAO;
import cn.zjc.entity.Address;
import cn.zjc.entity.User;
import cn.zjc.service.UserService;
import cn.zjc.util.JsonUtil;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import zjc.util.BaseSpringTestCase;

import java.util.*;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2016/1/19-15:17
 */
public class TestCode extends BaseSpringTestCase {


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressDAO addressDAO;

    @Test
    public void TestJsonFeatures() {
        User user = new User();
        user.setId(1);
        user.setName(null);
        user.setBirth(new Date());
        String s = JsonUtil.toJson(user);
        System.out.println(s);
    }

    @Test
    public void selectByID() {
        Example example = new Example(User.class);
        example.createCriteria().andGreaterThanOrEqualTo("id", 0);
        PageHelper.startPage(1, 2);
        List<User> user = userDAO.selectByExample(example);
        System.out.println(JsonUtil.toJson(user));
        System.out.println(JsonUtil.toJson(userService.findUserByPhone("22222222")));
    }


    @Test
    public void TestMap() {
        System.out.println(JsonUtil.toJson(userDAO.findByMap(100)));
    }

    @Test
    public void TestAddress() {
        Address ls = addressDAO.findByUserId(100);
        System.out.println(JsonUtil.toJson(ls));
    }

    @Test
    public void TestInsert() {
        Address a = new Address();
        a.setDetail("华南农业大学");
        a.setuId(3);
        Address b = new Address();
        b.setDetail("华南农业大学");
        b.setuId(3);
        List<Address> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        int id = addressDAO.insertList(list);
        System.out.println(id);
    }

    @Test
    public void TestJson(){
        Map<String , Object> map = new HashMap<>();
        map.put("zjc","");
        map.put("zzzz",null);
        map.put("sss",222);
        System.out.println(JsonUtil.toJson(map));
    }
}
