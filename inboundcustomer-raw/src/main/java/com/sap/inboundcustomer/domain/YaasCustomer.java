package com.sap.inboundcustomer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YaasCustomer extends YaasBaseItem {
    private String customerNumber = "";
    private String title = "";
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private String contactEmail = "";
    private String contactPhone = "";
    private String company = "";
    private String preferredLanguage = "";
    private String preferredCurrency = "";

    private List<YaasAddress> addresses = new ArrayList<YaasAddress>();
    private YaasAddress defaultAddress = new YaasAddress();

    public YaasCustomer() {
	addresses.add(new YaasAddress());
    }

    public YaasCustomer(String _customerNumber, String _title, String _firstName, String _middleName, String _lastName,
	    String _contactEmail, String _contactPhone, String _company, String _preferredLanguage,
	    String _preferredCurrency
	    , List<YaasAddress> _addresses,
	    YaasAddress _defaultAddress) {
	this.customerNumber = _customerNumber;
	this.title = _title;
	this.firstName = _firstName;
	this.middleName = _middleName;
	this.lastName = _lastName;
	this.contactEmail = _contactEmail;
	this.contactPhone = _contactPhone;
	this.company = _company;
	this.preferredLanguage = _preferredLanguage;
	this.preferredCurrency = _preferredCurrency;
	this.addresses = _addresses;
	this.defaultAddress = _defaultAddress;
    }

    public void setCustomerNumber(String _customerNumber) {
	this.customerNumber = _customerNumber;
    }

    public void setTitle(String _title) {
	this.title = _title;
    }

    public void setFirstName(String _firstName) {
	this.firstName = _firstName;
    }

    public void setMiddleName(String _middleName) {
	this.middleName = _middleName;
    }

    public void setLastName(String _lastName) {
	this.lastName = _lastName;
    }

    public void setContactEmail(String _contactEmail) {
	this.contactEmail = _contactEmail;
    }

    public void setContactPhone(String _contactPhone) {
	this.contactPhone = _contactPhone;
    }

    public void setCompany(String _company) {
	this.company = _company;
    }

    public void setPreferredLanguage(String _preferredLanguage) {
	this.preferredLanguage = _preferredLanguage;
    }

    public void setPreferredCurrency(String _preferredCurrency) {
	this.preferredCurrency = _preferredCurrency;
    }

    public void setAddresses(List<YaasAddress> _addresses) {
	this.addresses =
		_addresses;
    }

    public void setDefaultAddress(YaasAddress _defaultAddress)
    {
	this.defaultAddress = _defaultAddress;
    }

    @Override
    public List<Map<String, String>> createRawFragments() {

	List<Map<String, String>> results = new ArrayList();

	Map<String, String> result = this.createRawFragment();

	if (!this.addresses.isEmpty()) {
	    for (YaasAddress address : this.addresses) {
		List<Map<String, String>> addressFragments = address.createRawFragments();
		for (Map<String, String> addressFragment : addressFragments) {
		    addressFragment.putAll(result);
		    results.add(addressFragment);
		}
	    }
	}
	else {
	    YaasAddress address = new YaasAddress();
	    Map<String, String> addressFragment = address.createRawFragment();
	    addressFragment.putAll(result);
	    results.add(addressFragment);
	}

	return results;
    }

    @Override
    public Map<String, String> createRawFragment() {
	// TODO Auto-generated method stub
	Map<String, String> result = new HashMap();
	result.put("customerNumber", this.customerNumber);
	result.put("title", this.title);
	result.put("firstName", this.firstName);
	result.put("middleName", this.middleName);
	result.put("lastName", this.lastName);
	result.put("contactEmail", this.contactEmail);
	result.put("contactPhoneC", this.contactPhone);
	result.put("company", this.company);
	result.put("preferredLanguage", this.preferredLanguage);
	result.put("preferredCurrency", this.preferredCurrency);
	return result;
    }
}