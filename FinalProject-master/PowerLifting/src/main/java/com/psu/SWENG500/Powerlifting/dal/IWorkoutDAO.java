package com.psu.SWENG500.Powerlifting.dal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import com.psu.SWENG500.Powerlifting.models.*;

public interface IWorkoutDAO
{
	List<Workout> GetWorkouts(int userId) throws SQLException;
	Workout GetWorkout(int id) throws SQLException;
	Workout GetWorkoutByDate(Date workoutDate) throws SQLException;
	Workout CreateWorkout(Workout w, int userId) throws SQLException;
	Workout UpdateWorkout(Workout w);
	boolean DeleteWorkout(Workout w);
}