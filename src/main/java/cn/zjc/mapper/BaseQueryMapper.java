package cn.zjc.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by zjc.
 * 2016/1/20/0:32
 */
public interface BaseQueryMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
