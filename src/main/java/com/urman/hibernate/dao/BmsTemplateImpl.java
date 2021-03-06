package com.urman.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.urman.hibernate.pojo.AccountInfo;
import com.urman.hibernate.pojo.CustomerPersonalInfo;

@Repository
public class BmsTemplateImpl {

	@Autowired
	EntityManager entityManager;

	@Autowired
	AccountInfoRepository accountInfoRepository;

	@Autowired
	CustomerRepository customerRepository;

	public static Logger LOGGER = LoggerFactory.getLogger(BmsTemplateImpl.class);

	public List<AccountInfo> getLstAccountInfo1(List<Long> accountNumbers) {

		List<AccountInfo> lstAccountInfo = null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountInfo> query = cb.createQuery(AccountInfo.class);
		Root<AccountInfo> accountInfoRoot = query.from(AccountInfo.class);
		query.select(accountInfoRoot).where(accountInfoRoot.in(accountNumbers));
		lstAccountInfo = entityManager.createQuery(query).getResultList();

		return lstAccountInfo;
	}

	public List<AccountInfo> getLstAccountInfo2(List<Long> accountNumbers) {

		List<AccountInfo> lstAccountInfo = null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountInfo> query = cb.createQuery(AccountInfo.class);
		Root<AccountInfo> accountInfoRoot = query.from(AccountInfo.class);
		Join<AccountInfo, CustomerPersonalInfo> join = accountInfoRoot.join("customerPersonalInfo", JoinType.LEFT);
		query.select(accountInfoRoot)
				.where(cb.and(accountInfoRoot.in(accountNumbers), cb.equal(join.get("customerId"), "2")));
		lstAccountInfo = entityManager.createQuery(query).getResultList();

		return lstAccountInfo;
	}

	public List<AccountInfo> getAllAccounts() {

		List<AccountInfo> lstAccountInfo = accountInfoRepository.findAll();

		return lstAccountInfo;
	}

	public AccountInfo getAccountInfo(Long accountNumber) {
		return accountInfoRepository.getOne(accountNumber);
	}

	public List<AccountInfo> getCustomerAccounts(String customerId) {
		return accountInfoRepository.findByCustomerPersonalInfoCustomerId(customerId);
	}

	public CustomerPersonalInfo getCustomerInfo(long customerId) {

		return customerRepository.getOne(customerId);
	}

	public void createAccount(AccountInfo accountInfo) {
		accountInfoRepository.save(accountInfo);

	}

	public List<String> getAllCustomerIds() {

		List<String> customerIds = null;

		return customerIds;
	}

	public void createCustomer(CustomerPersonalInfo customer) {
		customerRepository.save(customer);

	}

	public List<CustomerPersonalInfo> getCustomers(List<Long> customerIds) {
		return customerRepository.findAllById(customerIds);
	}

}
