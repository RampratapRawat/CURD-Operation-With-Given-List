package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.entity.EntityClass;
import com.example.repository.RepositoryClass;
@Service
public class ServiceImpl implements ServiceClass {
	
	public static List<EntityClass> list=new ArrayList<>();
	
	static{
		list.add(new EntityClass(1,"Rajkumar","Rawat","Dabra"));
		list.add(new EntityClass(2,"Nivesh","kushwah","chandhpur"));
		list.add(new EntityClass(3,"Ram","Sharma","Goa"));
	}

	public RepositoryClass repository;
	
	
	public ServiceImpl(RepositoryClass repository) {
		super();
		this.repository = repository;
	}


	@Override
	public List<EntityClass> fetchAllData() {
		return list;
		
	}

	@Override
	public EntityClass fetchById(Long id) {
		return list.stream().filter(e->e.getId()==id).findFirst().get();
	}


	@Override
	public EntityClass updateList(EntityClass entityClass) {
		
		  list.add(entityClass);
		  return entityClass;
	}


	@Override
	public void delById(Long id) {
		list.remove(list.stream().filter(e->e.getId()==id).findFirst().get());
		
	}


	@Override
	public EntityClass value(Long id, EntityClass entityClass) {
		list.stream().map(e->{
			if(e.getId()==id) {
				e.setName(entityClass.getName());
				e.setCity(entityClass.getCity());
			}return e;
		}).collect(Collectors.toList());
		return entityClass;
	}


	@Override
	public void del() {
		list.removeAll(list);
		
	}

}
