package com.urman.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urman.hibernate.pojo.AccountInfo;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long>{
	
	List<AccountInfo> findByAccountNumberIn (List<Long> accountNumbers);

	List<AccountInfo> findByCustomerPersonalInfoCustomerId(String customerId);

}
