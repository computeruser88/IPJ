package com.psu.SWENG500.Powerlifting.dal;

public class MeasurementsDaoFactory
{
	private static IMeasurementsDAO dao = null;
	
	public static synchronized IMeasurementsDAO GetMeasurementDAO(String dbName)
	{
		return dao == null ? dao = new MeasurementsDAO(dbName) : dao;
	}
}