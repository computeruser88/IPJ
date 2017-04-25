package com.psu.SWENG500.Powerlifting;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.dal.*;
import com.psu.SWENG500.Powerlifting.models.*;

public class TestAccountDal extends TestCase
{
	private Account testAccount;
	private static final String TEST_DB = "C:\\temp";
	
	public void setUp() throws Exception
	{
		testAccount = new Account();
		testAccount.setFirstName("Test User");
		testAccount.setLastName("User");
		testAccount.setNickname("Test Nickname");
		testAccount.setEmailAddress("test@test.com");
		testAccount.setGender("Male");
	}
	
	public void testCreateAccount()
	{
		IAccountDAO dao = AccountDaoFactory.GetAccountDAO(TEST_DB);
		Account a = null;
		try
		{
			a = dao.CreateAccount(testAccount);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		assertNotNull(a);
	}
	
	public void testGetAccount()
	{
		//IAccountDAO dao = AccountDaoFactory.GetAccountDAO(TEST_DB);
		//Account a = null;
		//try
		//{
		//	a = dao.GetAccount(38);
		//} catch (SQLException e)
		//{
		//	fail(e.getLocalizedMessage());
		//}
		//assertNotNull(a);
	}
	
	public void testGetAccountNotFound()
	{
		IAccountDAO dao = AccountDaoFactory.GetAccountDAO(TEST_DB);
		Account a = null;
		try
		{
			a = dao.GetAccount(2000);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		assertNull(a);
	}
}