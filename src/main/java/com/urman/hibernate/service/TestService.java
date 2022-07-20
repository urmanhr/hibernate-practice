package com.urman.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.urman.hibernate.dao.BmsTemplateImpl;
import com.urman.hibernate.pojo.AccountInfo;
import com.urman.hibernate.pojo.CustomerPersonalInfo;

@Component
public class TestService {

	@Autowired
	BmsTemplateImpl bmsTemplateImpl;

	public List<AccountInfo> getAllAccounts(List<Long> accountNumbers) {

		return bmsTemplateImpl.getAllAccounts();
	}

	public AccountInfo getAccountInfo(Long accountNumber) {

		return bmsTemplateImpl.getAccountInfo(accountNumber);
	}

	public List<AccountInfo> getCustomerAccounts(String customerId) {

		return bmsTemplateImpl.getCustomerAccounts(customerId);
	}

	public void createAccount(AccountInfo accountInfo) {

		bmsTemplateImpl.createAccount(accountInfo);
	}

	public List<String> getAllCustomerIds() {

		return bmsTemplateImpl.getAllCustomerIds();
	}

	public List<AccountInfo> getAccountList(List<Long> accountIds) {
		return bmsTemplateImpl.getLstAccountInfo1(accountIds);
	}

	public void createCustomer(CustomerPersonalInfo customer) {
		bmsTemplateImpl.createCustomer(customer);

	}

	public CustomerPersonalInfo getCustomerInfo(long customerId) {
		return bmsTemplateImpl.getCustomerInfo(customerId);
	}

	public List<CustomerPersonalInfo> getCustomerList(List<Long> customerIds) {
		return bmsTemplateImpl.getCustomers(customerIds);
	}
}
