package cn.zjc.dao;

import cn.zjc.entity.Address;
import cn.zjc.mapper.BaseQueryMapper;
import org.springframework.stereotype.Repository;


/**
 * Created by zjc on 2016/1/24.
 */
@Repository
public interface AddressDAO extends BaseQueryMapper<Address> {

    Address findByUserId(int id);
}
