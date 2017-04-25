package com.psu.SWENG500.Powerlifting.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;
import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.models.MetricMeasurement;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

public class MeasurementsDAO implements IMeasurementsDAO
{
private String dbName;
	
	protected MeasurementsDAO(String dbName)
	{
		this.dbName = dbName;
	}
	
	public List<Measurements> GetMeasurements(int userId) throws SQLException
	{
		List<Measurements> userMeasurements = null;
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
		try
		{
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM SWENG500.USERMEASUREMENTS WHERE USERID=? ORDER BY MEASUREMENTDATE ASC";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, userId);
			ResultSet rs = prep.executeQuery();
			userMeasurements = new ArrayList<Measurements>();
			while (rs.next())
			{
				Measurements tempMeasurement = new ImperialMeasurement();
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTimeInMillis(rs.getTimestamp("MEASUREMENTDATE").getTime());
				tempMeasurement.setMeasurementDate(tempCal.getTime());
				tempMeasurement.setHeight(rs.getDouble("HEIGHT"));
				tempMeasurement.setWeight(rs.getDouble("WEIGHT"));
				tempMeasurement.setWaist(rs.getDouble("WASIT"));
				tempMeasurement.setNeck(rs.getDouble("NECK"));
				tempMeasurement.setHip(rs.getDouble("HIP"));
				tempMeasurement.setWrist(rs.getDouble("WRIST"));
				tempMeasurement.setForearm(rs.getDouble("FOREARM"));
				userMeasurements.add(tempMeasurement);
			}
			prep.close();
			conn.commit();
		} catch (SQLException e)
        {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
        return userMeasurements;
	}

	public void CreateMeasurement(Measurements m) throws SQLException
	{
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "INSERT INTO SWENG500.USERMEASUREMENTS (USERID, MEASUREMENTDATE, HEIGHT, WEIGHT, WASIT, NECK, HIP, WRIST, FOREARM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, m.getUserId());
        	prep.setDate(2, (Date) m.getMeasurementDate());
        	prep.setDouble(3, m.getHeight());
        	prep.setDouble(4, m.getWeight());
        	prep.setDouble(5, m.getWaist());
        	prep.setDouble(6, m.getNeck());
        	prep.setDouble(7, m.getHip());
        	prep.setDouble(8, m.getWrist());
        	prep.setDouble(9, m.getForearm());
        	prep.executeUpdate();
        	ResultSet newId = prep.getGeneratedKeys();
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

	public void UpdateMeasurement(Measurements m) throws SQLException
	{
		
	}

	public boolean DeleteMeasurement(Measurements m)
	{
		return false;
	}
}