package com.appsdeveloperblog.app.ws.ui.model.response;

import com.appsdeveloperblog.app.ws.io.value.UserAddress;

import java.util.ArrayList;
import java.util.Collection;

public class UserRest {

	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private Collection<UserAddress> userAddressSet = new ArrayList<>();

	public Collection<UserAddress> getUserAddressSet() {
		return userAddressSet;
	}

	public void setUserAddressSet(Collection<UserAddress> userAddressSet) {
		this.userAddressSet = userAddressSet;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
