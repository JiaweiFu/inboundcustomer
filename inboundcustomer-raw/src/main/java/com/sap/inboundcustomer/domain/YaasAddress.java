package com.sap.inboundcustomer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YaasAddress extends YaasBaseItem {
    private String id = "";
    private String contactName = "";
    private String companyName = "";
    private String street = "";
    private String streetNumber = "";
    private String streetAppendix = "";
    private String zipCode = "";
    private String city = "";
    private String country = "";
    private String state = "";
    private String contactPhone = "";
    private List<String> tags = new ArrayList<String>();
    private Boolean isDefault = false;

    public YaasAddress() {
	tags.add("");
    }

    public YaasAddress(String _id, String _contactName, String _companyName, String _street, String _streetNumber,
	    String _streetAppendix, String _zipCode, String _city, String _country, String _state,
	    String _contactPhone, List<String> _tags, Boolean _isDefault) {
	this.id = _id;
	this.contactName = _contactName;
	this.companyName = _companyName;
	this.street = _street;
	this.streetNumber = _streetNumber;
	this.streetAppendix = _streetAppendix;
	this.zipCode = _zipCode;
	this.city = _city;
	this.country = _country;
	this.state = _state;
	this.contactPhone = _contactPhone;
	this.tags = _tags;
	this.isDefault = _isDefault;
    }

    public void setId(String _id) {
	this.id = _id;
    }

    public void setContactName(String _contactName) {
	this.contactName = _contactName;
    }

    public void setCompanyName(String _companyName) {
	this.companyName = _companyName;
    }

    public void setStreet(String _street) {
	this.street = _street;
    }

    public void setStreetNumber(String _streetNumber) {
	this.streetNumber = _streetNumber;
    }

    public void setStreetAppendix(String _streetAppendix) {
	this.streetAppendix = _streetAppendix;
    }

    public void setZipCode(String _zipCode) {
	this.zipCode = _zipCode;
    }

    public void setCity(String _city) {
	this.city = _city;
    }

    public void setCountry(String _country) {
	this.country = _country;
    }

    public void setState(String _state) {
	this.state = _state;
    }

    public void setContactPhone(String _contactPhone) {
	this.contactPhone = _contactPhone;
    }

    public void setTags(List<String> _tags) {
	this.tags = _tags;
    }

    public void setIsDefault(Boolean _isDefault) {
	this.isDefault = _isDefault;
    }

    @Override
    public String toString() {
	return new StringBuffer(" id : ").append(this.id)
		.append(" contactName : ").append(this.contactName)
		.append(" companyName : ").append(this.companyName)
		.append(" street : ").append(this.street)
		.append(" streetNumber : ").append(this.streetNumber)
		.append(" streetAppendix : ").append(this.streetAppendix)
		.append(" zipCode : ").append(this.zipCode)
		.append(" city : ").append(this.city)
		.append(" country : ").append(this.country)
		.append(" state : ").append(this.state)
		.append(" contactPhone : ").append(this.contactPhone)
		.append(" tags : ").append(this.tags.toString())
		.append(" isDefault : ").append(this.isDefault)
		.toString();
    }

    @Override
    public Map<String, String> createRawFragment() {
	Map<String, String> result = new HashMap<String, String>();
	result.put("addressID", this.id);
	result.put("companyName", this.companyName);
	result.put("street", this.street);
	result.put("streetNumber", this.streetNumber);
	result.put("streetAppendix", this.streetAppendix);
	result.put("zipCode", this.zipCode);
	result.put("city", this.city);
	result.put("country", this.country);
	result.put("state", this.state);
	result.put("contactPhoneA", this.contactPhone);
	// result.put("tags", this.tags.toString());
	result.put("isDefault", String.valueOf(this.isDefault));

	return result;
    }

    @Override
    public List<Map<String, String>> createRawFragments() {
	// TODO Auto-generated method stub
	List<Map<String, String>> results = new ArrayList<Map<String, String>>();

	if (this.tags.size() != 0) {
	    for (String tag : this.tags) {
		Map<String, String> result = this.createRawFragment();
		result.put("tag", tag);
		results.add(result);
	    }
	}
	else
	{
	    Map<String, String> result = this.createRawFragment();
	    result.put("tag", "");
	    results.add(result);
	}
	return results;
    }
}