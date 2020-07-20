package com.appsdeveloperblog.app.ws.io.entity;

import com.appsdeveloperblog.app.ws.io.value.UserAddress;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 5313493413859894403L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120)
	private String email;

	//@Embedded
	//private UserAddress userAddress;

	//@GenericGenerator(name = "increment-gen", strategy = "increment")
	//@CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator = "increment-gen", type = @Type(type = "long"))
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns=@JoinColumn(name = "USER_ID"))
	private Collection<UserAddress> userAddressSet = new ArrayList<>();

	@Column(nullable = false)
	private String encryptedPassword;

	private String emailVerificationToken;

	@Column(nullable = false)
	private Boolean emailVerificationTokenStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	/*public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}*/

	public Collection<UserAddress> getUserAddressSet() {
		return userAddressSet;
	}

	public void setUserAddressSet(Collection<UserAddress> userAddressSet) {
		this.userAddressSet = userAddressSet;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public Boolean getEmailVerificationTokenStatus() {
		return emailVerificationTokenStatus;
	}

	public void setEmailVerificationTokenStatus(Boolean emailVerificationTokenStatus) {
		this.emailVerificationTokenStatus = emailVerificationTokenStatus;
	}

}
