package com.psu.SWENG500.Powerlifting.dal;

public class WorkoutDaoFactory
{
	private static IWorkoutDAO dao = null;
	
	public static synchronized IWorkoutDAO GetWorkoutDAO(String dbName)
	{
		return dao == null ? dao = new WorkoutDAO(dbName) : dao;
	}
}