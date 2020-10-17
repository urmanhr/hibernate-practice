package com.urman.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "customer_personal_info")
@JsonInclude(Include.NON_NULL)
public class CustomerPersonalInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "guardian_name")
	private String guardianName;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_no")
	private Long contactNo;

	@Column(name = "mail_id")
	private String mailId;

	@Column(name = "gender")
	private String gender;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "identification_doc_type")
	private String idDocType;

	@Column(name = "id_doc_no")
	private String idDocNo;

	@Column(name = "citizenship")
	private String citizenship;

	@OneToMany(mappedBy = "customerPersonalInfo", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<AccountInfo> lstAccounts;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getIdDocType() {
		return idDocType;
	}

	public void setIdDocType(String idDocType) {
		this.idDocType = idDocType;
	}

	public String getIdDocNo() {
		return idDocNo;
	}

	public void setIdDocNo(String idDocNo) {
		this.idDocNo = idDocNo;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public List<AccountInfo> getLstAccounts() {
		return lstAccounts;
	}

	public void setLstAccounts(List<AccountInfo> lstAccounts) {
		this.lstAccounts = lstAccounts;
	}
}
