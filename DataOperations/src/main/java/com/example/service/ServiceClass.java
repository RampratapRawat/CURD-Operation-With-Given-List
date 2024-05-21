package com.example.service;

import java.util.List;

import com.example.entity.EntityClass;
public interface ServiceClass {

	public List<EntityClass> fetchAllData();

	public EntityClass fetchById(Long id);

	public EntityClass updateList(EntityClass entityClass);

	public void delById(Long id);

	public EntityClass value(Long id, EntityClass entityClass);

	public void del();

}
