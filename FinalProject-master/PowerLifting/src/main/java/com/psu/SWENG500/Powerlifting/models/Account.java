package com.psu.SWENG500.Powerlifting.models;

public class Account
{
	private int userId;
	private String firstName;
	private String lastName;
	private String nickname;
	private String emailAddress;
	private String gender;
	private String password;
	
	public Account()
	{
	}
	
	public Account CreateAccount(String email, String pwd)
	{
		Account tempAccount = new Account();
		tempAccount.setEmailAddress(email);
		tempAccount.setPassword(pwd);
		return tempAccount;
	}
	
	public void ModifyAccount(String firstName, String nickname, String emailAddress, String phoneNumber, String gender, String mfpUsername, String mfpPwd, double height)
	{
		this.firstName = firstName;
		this.nickname = nickname;
		this.emailAddress = emailAddress;
		this.gender = gender;
	}
	
	public boolean Login()
	{
		return false;
	}
	
	public boolean Logout()
	{
		return false;
	}
	
	public int getUserId()
	{
		return this.userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}