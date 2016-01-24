package cn.zjc.dao;

import cn.zjc.entity.User;
import cn.zjc.mapper.BaseQueryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zjc.
 * 2016/1/23/1:01
 */
@Repository
public interface UserDAO extends BaseQueryMapper<User> {

    List<User> findByPhone(String phone);

    List<User> findByMap(int id);
}
