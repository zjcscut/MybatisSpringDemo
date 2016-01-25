package zjc.core;

import cn.zjc.dao.AddressDAO;
import cn.zjc.dao.UserDAO;
import cn.zjc.entity.Address;
import cn.zjc.entity.User;
import cn.zjc.service.UserService;
import cn.zjc.util.JsonUtil;
import cn.zjc.util.PageBean;
import cn.zjc.util.PaginationContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Integer pageNum = 1;
        Integer pageSize = 2;
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = userDAO.selectByExample(example);
//        System.out.println(JsonUtil.toJson(new PageInfo<>(user)));
        System.out.println(JsonUtil.toJson(new PageBean<>(user)));
//        System.out.println(JsonUtil.toJson(userService.findUserByPhone("123456789111")));
    }


    @Test
    public void TestMap() {
        System.out.println(JsonUtil.toJson(userDAO.findByMap(100)));
    }

    @Test
    public void TestAddress() {
        List<User> ls = userDAO.findByPhone("12345678910");
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
    public void TestJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("zjc", "");
        map.put("zzzz", null);
        map.put("sss", 222);
        System.out.println(JsonUtil.toJson(map));
    }

    @Test
    public void TestTransation() {
        System.out.println(JsonUtil.toJson(userDAO.findUserAndAddress("zjc")));
    }
}
