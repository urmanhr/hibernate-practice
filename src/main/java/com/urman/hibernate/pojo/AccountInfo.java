package com.urman.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "account_info")
@JsonInclude(Include.NON_NULL)
public class AccountInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_no")
	private long accountNumber;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "activation_date")
	private Date activationDate;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "interest")
	private Float interest;

	@Column(name = "intial_deposit")
	private Long intialDeposit;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	CustomerPersonalInfo customerPersonalInfo;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public CustomerPersonalInfo getCustomerPersonalInfo() {
		return customerPersonalInfo;
	}

	public void setCustomerPersonalInfo(CustomerPersonalInfo customerPersonalInfo) {
		this.customerPersonalInfo = customerPersonalInfo;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Long getIntialDeposit() {
		return intialDeposit;
	}

	public void setIntialDeposit(Long intialDeposit) {
		this.intialDeposit = intialDeposit;
	}
}
