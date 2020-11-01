package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LoginData;

@Repository
public interface LoginRepository extends CrudRepository<LoginData, Long> {

}
