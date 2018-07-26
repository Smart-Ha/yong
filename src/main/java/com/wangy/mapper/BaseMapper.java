package com.wangy.mapper;

import java.util.List;

/**
 * 使用mybatis的超类
 * @param <T>
 * @param <ID>
 */
public interface BaseMapper<T,ID> {
    T selectByPrimaryKey(ID id);
    List<T> selectByCondition(T condition);
    T insert(T entity);
    int update(T newEntity);
    int deleteByPrimaryKey(ID id);
    long countByCondition(T condition);
}
