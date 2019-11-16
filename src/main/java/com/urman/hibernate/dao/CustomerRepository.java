package com.urman.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urman.hibernate.pojo.CustomerPersonalInfo;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerPersonalInfo, String>{
	

}
