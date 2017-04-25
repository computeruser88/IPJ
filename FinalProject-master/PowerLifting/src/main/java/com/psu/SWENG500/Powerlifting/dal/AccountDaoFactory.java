package com.psu.SWENG500.Powerlifting.dal;

public class AccountDaoFactory
{
	private static IAccountDAO dao = null;
	
//	protected static synchronized IAccountDAO setDao(IAccountDAO d)
//	{
//		IAccountDAO old = dao;
//		dao = d;
//		return dao;
//	}
	
	public static synchronized IAccountDAO GetAccountDAO(String dbName)
	{
		return dao == null ? dao = new AccountDAO(dbName) : dao;
	}
}