package com.psu.SWENG500.Powerlifting.dal;

import java.util.List;

import com.psu.SWENG500.Powerlifting.models.Account;
import java.sql.*;

public class AccountDAO implements IAccountDAO
{
	private String dbName;
	
	protected AccountDAO(String dbName)
	{
		this.dbName = dbName;
	}
	
	public List<Account> GetAccounts()
	{
		return null;
	}

	public Account GetAccount(int id) throws SQLException
	{
		Account tempAccount = null;
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "SELECT * FROM SWENG500.USERS WHERE ID=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, id);
        	ResultSet rs = prep.executeQuery();
        	if (rs.next())
            {
        		tempAccount = new Account();
        		tempAccount.setUserId(rs.getInt("ID"));
        		tempAccount.setFirstName(rs.getString("FIRSTNAME"));
        		tempAccount.setLastName(rs.getString("LASTNAME"));
        		tempAccount.setNickname(rs.getString("NICKNAME"));
        		tempAccount.setEmailAddress(rs.getString("EMAILADDRESS"));
        		tempAccount.setGender(rs.getString("GENDER"));
        		prep.close();
            }
            conn.commit();
        } catch (SQLException e)
        {
        	throw e;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
        return tempAccount;
	}
	
	public Account GetAccount(String userName, String password) throws SQLException
	{
		Account tempAccount = null;
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	//String sql = "SELECT * FROM SWENG500.USERS WHERE EMAILADDRESS=? AND PASSWORD=?";
        	String sql = "SELECT * FROM SWENG500.USERS WHERE NICKNAME=? AND PASSWORD=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, userName);
        	prep.setString(2, password);
        	ResultSet rs = prep.executeQuery();
        	if (rs.next())
            {
        		tempAccount = new Account();
        		tempAccount.setUserId(rs.getInt("ID"));
        		tempAccount.setFirstName(rs.getString("FIRSTNAME"));
        		tempAccount.setLastName(rs.getString("LASTNAME"));
        		tempAccount.setNickname(rs.getString("NICKNAME"));
        		tempAccount.setEmailAddress(rs.getString("EMAILADDRESS"));
        		tempAccount.setGender(rs.getString("GENDER"));
        		tempAccount.setPassword(rs.getString("PASSWORD"));
        		prep.close();
            }
            conn.commit();
        } catch (SQLException e)
        {
        	throw e;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
        return tempAccount;
	}
	
	public Account CreateAccount(Account a) throws SQLException
	{
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "INSERT INTO SWENG500.USERS (FIRSTNAME, LASTNAME, NICKNAME, EMAILADDRESS, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";// * FROM USERS WHERE PASSWORD=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, a.getFirstName());
        	prep.setString(2, a.getLastName());
        	prep.setString(3, a.getNickname());
        	prep.setString(4, a.getEmailAddress());
        	prep.setString(5, a.getGender());
        	prep.setString(6,  a.getPassword());
        	prep.executeUpdate();
        	ResultSet newId = prep.getGeneratedKeys();
        	if (newId.next())
        		a.setUserId(newId.getInt(1));
        	prep.close();
            conn.commit();
        } catch (SQLException e)
        {
        	throw e;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
        return a;
	}

	public void UpdateAccount(Account a) throws SQLException
	{
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "UPDATE SWENG500.USERS SET FIRSTNAME=?, LASTNAME=?, EMAILADDRESS=?, PASSWORD=? WHERE ID=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, a.getFirstName());
        	prep.setString(2, a.getLastName());
        	prep.setString(3, a.getEmailAddress());
        	prep.setString(4, a.getPassword());
        	prep.setInt(5,  a.getUserId());
        	prep.executeUpdate();
        	prep.close();
            conn.commit();
        } catch (SQLException e)
        {
        	throw e;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
	}

	public boolean DeleteAccount(Account a)
	{
		return false;
	}
}