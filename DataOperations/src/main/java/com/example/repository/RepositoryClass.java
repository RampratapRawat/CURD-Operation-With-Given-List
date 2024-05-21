package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entity.EntityClass;

public interface RepositoryClass extends JpaRepository<EntityClass,Long> {

}
