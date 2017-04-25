package com.psu.SWENG500.Powerlifting.dal;

import java.sql.SQLException;
import java.util.List;

import com.psu.SWENG500.Powerlifting.models.Measurements;

public interface IMeasurementsDAO
{
	List<Measurements> GetMeasurements(int userId) throws SQLException;
	void CreateMeasurement(Measurements m) throws SQLException;
	void UpdateMeasurement(Measurements m) throws SQLException;
	boolean DeleteMeasurement(Measurements m);
}