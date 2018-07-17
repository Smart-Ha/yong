package com.wangy.service;

public interface IBaseService<Entity> {
    Entity findById(Long id);
    Boolean deleteById(Long id);
    Entity update(Entity entity);
}
