package com.sap.inboundcustomer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawCustomer extends YaasBaseItem {
    private String firstName = "";
    private String lastName = "";
    private String accountGroup = "";
    private String street = "";
    private String city = "";
    private String telNumber = "";
    private String houseNumber = "";
    private String postalCode = "";
    private String country = "";
    private String region = "";
    private String billTo = "";
    private String shipTo = "";
    private String integrationKey = "";
    private String preferredLanguage = "";
    private String title = "";
    private String customerNumber = "";
    private String email = "";
    private String company = "";

    public RawCustomer() {

    }

    public RawCustomer(String _firstName, String _lastName, String _accountGroup, String _street, String _city,
	    String _telNumber,
	    String _houseNumber, String _postalCode, String _country, String _region,
	    String _billTo, String _shipTo, String _integrationKey, String _preferredLanguage, String _title,
	    String _customerNumber, String _email, String _company) {
	this.firstName = _firstName;
	this.lastName = _lastName;
	this.accountGroup = _accountGroup;
	this.street = _street;
	this.city = _city;
	this.telNumber = _telNumber;
	this.houseNumber = _houseNumber;
	this.postalCode = _postalCode;
	this.country = _country;
	this.region = _region;
	this.billTo = _billTo;
	this.shipTo = _shipTo;
	this.integrationKey = _integrationKey;
	this.preferredLanguage = _preferredLanguage;
	this.customerNumber = _customerNumber;
	this.title = _title;
	this.email = _email;
	this.company = _company;
    }

    public void setFirstName(String _firstName) {
	this.firstName = _firstName;
    }

    public void setLastName(String _lastName) {
	this.lastName = _lastName;
    }

    public void setTitle(String _title) {
	this.title = _title;
    }

    public void setEmail(String _email) {
	this.email = _email;
    }

    public void setPreferredLanguage(String _preferredLanguage) {
	this.preferredLanguage = _preferredLanguage;
    }

    public void setCustomerNumber(String _customerNumber) {
	this.customerNumber = _customerNumber;
    }

    public void setAccountGroup(String _accountGroup) {
	this.accountGroup = _accountGroup;
    }

    public void setStreet(String _street) {
	this.street = _street;
    }

    public void setCity(String _city) {
	this.city = _city;
    }

    public void setTelNumber(String _telNumber) {
	this.telNumber = _telNumber;
    }

    public void setHouseNumber(String _houseNumber) {
	this.houseNumber = _houseNumber;
    }

    public void setPostalCode(String _postalCode) {
	this.postalCode = _postalCode;
    }

    public void setCountry(String _country) {
	this.country = _country;
    }

    public void setRegion(String _region) {
	this.region = _region;
    }

    public void setBillTo(String _billTo) {
	this.billTo = _billTo;
    }

    public void setShipTo(String _shipTo) {
	this.shipTo = _shipTo;
    }

    public void setIntegrationKey(String _integrationKey) {
	this.integrationKey =
		_integrationKey;
    }

    public void setCompany(String _company) {
	this.company = _company;
    }

    @Override
    public Map<String, String> createRawFragment() {
	// TODO Auto-generated method stub
	Map<String, String> result = new HashMap();
	result.put("firstName", this.firstName);
	result.put("lastName", this.lastName);
	result.put("accountGroup", this.accountGroup);
	result.put("street", this.street);
	result.put("city", this.city);
	result.put("telNumber", this.telNumber);
	result.put("houseNumber", this.houseNumber);
	result.put("postalCode", this.postalCode);
	result.put("country", this.country);
	result.put("region", this.region);
	result.put("billTo", this.billTo);
	result.put("shipTo", this.shipTo);
	result.put("integrationKey", this.integrationKey);
	result.put("title", this.title);
	result.put("customerNumber", this.customerNumber);
	result.put("email", this.email);
	result.put("company", this.company);
	result.put("preferredLanguage", this.preferredLanguage);
	return result;
    }

    @Override
    public List<Map<String, String>> createRawFragments() {
	// TODO Auto-generated method stub
	List<Map<String, String>> results = new ArrayList<Map<String, String>>();
	results.add(this.createRawFragment());
	return results;
    }
}