package com.psu.SWENG500.Powerlifting;

import java.sql.*;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.dal.*;

public class TestH2Connection extends TestCase
{
	public void testGetConnection()
	{
		Connection conn = H2ConnectionFactory.GetConnection();
		assertNotNull(conn);
	}
	
	public void testGetConnectionWithParam()
	{
		Connection conn = H2ConnectionFactory.GetConnection("C:\\temp");
		assertNotNull(conn);
	}
}