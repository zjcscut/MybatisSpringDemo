package cn.zjc.service.impl;

import cn.zjc.dao.UserDAO;
import cn.zjc.entity.User;
import cn.zjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zjc.
 * 2016/1/21/14:42
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findUserByPhone(String phone) {
        List<User> list = userDAO.findByPhone(phone);
        return list;
    }
}
