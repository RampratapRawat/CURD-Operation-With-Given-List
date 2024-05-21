package com.example.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.entity.EntityClass;
import com.example.service.ServiceClass;

@RestController
public class Controller {
    private  ServiceClass service;

	public Controller(ServiceClass service) {
		super();
		this.service = service;
	}
	
	//Get the list of data 
	@GetMapping("/show")
	public List<EntityClass> check(){
		return service.fetchAllData();
	}
	
	//Get the ID row data from List
	@GetMapping("/show/{id}")
	public EntityClass check1(@PathVariable Long id){
		return service.fetchById(id);
	}
	
	//Insert new data inside the List
	@PostMapping("/insert")
	public EntityClass check2(@RequestBody EntityClass entityClass) {
		return service.updateList(entityClass);
	}
	
	//Delete the row of given Id
	@DeleteMapping("/del/{id}")
	public String check3(@PathVariable Long id) {
		service.delById(id);
		return "value has been delete";
	}
	
	//Delete The whole List 
	@DeleteMapping("/del")
	public String check5(){
		service.del();
		return "whole data has been deleted";
	}
	
	//Update the row data that belongs to given Id
	@PutMapping("/update/{id}")
	public EntityClass check4(@PathVariable Long id,@RequestBody EntityClass entityClass){
	     return service.value(id,entityClass);
	}
}
