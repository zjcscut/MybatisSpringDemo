package cn.zjc.service;

import cn.zjc.entity.User;

import java.util.List;

/**
 * Created by zjc.
 * 2016/1/21/14:41
 */
public interface UserService {

    List<User> findUserByPhone(String phone);
}
