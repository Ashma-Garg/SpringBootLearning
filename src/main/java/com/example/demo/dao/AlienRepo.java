package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//can use CrudRepository also at the palce of JpaRepository
public interface AlienRepo extends JpaRepository<AlienInterface, Integer>{

}
