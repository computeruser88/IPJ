package com.psu.SWENG500.Powerlifting.models.ui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AccountUI {

	private SimpleIntegerProperty userId = new SimpleIntegerProperty();
	private SimpleStringProperty firstName = new SimpleStringProperty();
	private SimpleStringProperty lastName = new SimpleStringProperty();
	private SimpleStringProperty nickname = new SimpleStringProperty();
	private SimpleStringProperty emailAddress = new SimpleStringProperty();
	private SimpleStringProperty phoneNumber = new SimpleStringProperty();
	private SimpleStringProperty gender = new SimpleStringProperty();
	private SimpleStringProperty mfpUsername = new SimpleStringProperty();
	private SimpleStringProperty mfpPwd = new SimpleStringProperty();
	private SimpleStringProperty username = new SimpleStringProperty();
	private SimpleStringProperty password = new SimpleStringProperty();
	private SimpleDoubleProperty height = new SimpleDoubleProperty();
	
	public AccountUI(){
	}
	
	public AccountUI(int userId, String firstName, String lastName, String nickname, String emailAddress, 
			String phoneNumer, String gender, String mfpUsername, String mfpPwd, String username, 
			String password, double height){
		this.userId.setValue(userId);
		this.firstName.setValue(firstName);
		this.lastName.setValue(lastName);
		this.nickname.setValue(nickname);
		this.emailAddress.setValue(emailAddress);
		this.phoneNumber.setValue(phoneNumer);
		this.gender.setValue(gender);
		this.mfpPwd.setValue(mfpPwd);
		this.mfpUsername.setValue(mfpUsername);
		this.height.setValue(height);
		this.username.setValue(username);
		this.password.setValue(password);
	}
	
	public int getUserId() {
		return userId.getValue();
	}
	
	public void setUserId(int userId) {
		this.userId.setValue(userId);
	}
	
	public String getFirstName() {
		return firstName.getValue();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}
	
	public String getLastName() {
		return lastName.getValue();
	}
	
	public void setLastName(String lastName) {
		this.lastName.setValue(lastName);
	}
	
	public String getNickname() {
		return nickname.getValue();
	}
	
	public void setNickname(String nickname) {
		this.nickname.setValue(nickname);
	}
	
	public String getEmailAddress() {
		return emailAddress.getValue();
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress.setValue(emailAddress);
	}
	
	public String getPhoneNumber() {
		return phoneNumber.getValue();
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.setValue(phoneNumber);
	}
	
	public String getGender() {
		return gender.getValue();
	}
	
	public void setGender(String gender) {
		this.gender.setValue(gender);
	}
	
	public String getMfpUsername() {
		return mfpUsername.getValue();
	}
	
	public void setMfpUsername(String mfpUsername) {
		this.mfpUsername.setValue(mfpUsername);
	}
	
	public String getMfpPwd() {
		return mfpPwd.getValue();
	}
	
	public void setMfpPwd(String mfpPwd) {
		this.mfpPwd.setValue(mfpPwd);
	}
	
	public String getUsername() {
		return username.getValue();
	}

	public void setUsername(String username) {
		this.username.setValue(username);
	}

	public String getPassword() {
		return password.getValue();
	}

	public void setPassword(String password) {
		this.password.setValue(password);
	}
	
	public double getHeight() {
		return height.getValue();
	}
	
	public void setHeight(double height) {
		this.height.setValue(height);
	}
}
