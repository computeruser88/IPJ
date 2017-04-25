package com.psu.SWENG500.Powerlifting;

import junit.framework.TestCase;
import com.psu.SWENG500.Powerlifting.models.*;

public class TestAccount extends TestCase
{
	private Account tempAccount;
	
	public void testName()
	{
		tempAccount = new Account();
		tempAccount.setFirstName("John");
		assertEquals("John", tempAccount.getFirstName());
	}
	
	public void testNickname()
	{
		tempAccount = new Account();
		tempAccount.setNickname("John");
		assertEquals("John", tempAccount.getNickname());
	}
	
	public void testEmailAddress()
	{
		tempAccount = new Account();
		tempAccount.setEmailAddress("John.Smith@aol.com");
		assertEquals("John.Smith@aol.com", tempAccount.getEmailAddress());
	}
	
	public void testGender()
	{
		tempAccount = new Account();
		tempAccount.setGender("Male");
		assertEquals("Male", tempAccount.getGender());
	}
	
//	@Test
//	public void testPassword()
//	{
//		tempAccount = new Account();
//		tempAccount.setPassword("1234567890");
//		Assert.assertEquals("1234567890", tempAccount.getPassword());
//	}
	
//	@Test
//	public void testCreateAccount()
//	{
//		tempAccount = new Account();
//		tempAccount.CreateAccount("JSmith", "12345");
//		Assert.assertEquals("JSmith", tempAccount.getUsername());
//	}
	
	public void testModifyAccount()
	{
//		fail("Not yet implemented");
	}
	
	public void testLogin()
	{
		tempAccount = new Account();
		tempAccount.CreateAccount("JSmith", "12345");
		assertFalse(tempAccount.Login());
	}
	
	public void testLogout()
	{
		tempAccount = new Account();
		tempAccount.CreateAccount("JSmith", "12345");
		assertFalse(tempAccount.Logout());
	}
}