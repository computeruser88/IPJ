package com.psu.SWENG500.Powerlifting.controller;

import java.net.URL;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import com.psu.SWENG500.Powerlifting.application.ui.RestrictiveTextField;
import com.psu.SWENG500.Powerlifting.dal.AccountDaoFactory;
import com.psu.SWENG500.Powerlifting.dal.IAccountDAO;
import com.psu.SWENG500.Powerlifting.dal.IMeasurementsDAO;
import com.psu.SWENG500.Powerlifting.dal.IWorkoutDAO;
import com.psu.SWENG500.Powerlifting.dal.MeasurementsDaoFactory;
import com.psu.SWENG500.Powerlifting.dal.WorkoutDaoFactory;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;
import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;
import com.psu.SWENG500.Powerlifting.models.ui.WorkoutSetUI;
import com.psu.SWENG500.Powerlifting.models.Account;
import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;
import com.psu.SWENG500.Powerlifting.models.ui.AccountUI;
import com.psu.SWENG500.Powerlifting.models.ui.NewsArticle;
import com.psu.SWENG500.Powerlifting.models.ui.WorkoutSetUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML private RestrictiveTextField usernameTextField;
	@FXML private PasswordField passwordTextField;
	@FXML private Button loginButton;
	@FXML private ScrollBar workoutScrollBar;
	@FXML private TableView<WorkoutSetUI> workoutTable;
	@FXML private RestrictiveTextField weightTextBox;
	@FXML private RestrictiveTextField repsTextBox;
	@FXML private ComboBox<String> addExercise;
	@FXML private Button removeExercise;
	@FXML private Button addSet;
	@FXML private Button removeSet;
	@FXML private Button logWorkout;
	@FXML private DatePicker workoutDate;
	@FXML LineChart<String, Number> exerciseLineChart;
	@FXML LineChart<String, Number> bodyCompositionLineChart;
	@FXML private ComboBox<String> exerciseComboBox;
	@FXML private ComboBox<String> bodyCompositionComboBox;
	@FXML private TextField searchTextBox;
	@FXML private Button searchButton;
	@FXML private ComboBox<String> searchHistory;
	@FXML private WebView webView;
	@FXML private ScrollBar articleScrollBar;
	@FXML private Button article1;
	@FXML private Button article2;
	@FXML private Button article3;
	@FXML private DatePicker measurementsDate;
	@FXML private ComboBox<String> heightInFeetComboBox;
	@FXML private ComboBox<String> heightInInchesComboBox;
	@FXML private TextField weightTextField;
	@FXML private TextField neckTextField;
	@FXML private TextField waistTextField;
	@FXML private Button saveMeasurementsButton;
	@FXML private Label loginErrorLabel;
	@FXML private Label workoutLogErrorLabel;
	@FXML private Label articleErrorLabel;
	@FXML private Label weightErrorLabel;
	@FXML private Label neckErrorLabel;
	@FXML private Label waistErrorLabel;
	@FXML private TextField firstNameTextField;
	@FXML private TextField lastNameTextField;
	@FXML private TextField emailTextField;
	@FXML private TextField usernameSetTextField;
	@FXML private TextField passwordSetTextField;
	@FXML private ComboBox<String> genderComboBox;
	
	@FXML private TabPane tcPnls;
	@FXML private Tab workoutTab;
	@FXML private Tab articlesTab;
	@FXML private Tab statisticsTab;
	@FXML private Tab measurementsTab;
	@FXML private Tab settingsTab;
	@FXML private Label lblCurrentUser;
	
	private Account currentUser;
	
	ObservableList<String> exerciseList = FXCollections.observableArrayList("Back Extension", 
				"Bench Press, Barbell", "Bench Press, Close Grip", "Bench Press, Dumbbell",
				"Biceps Curl, Barbell", "Biceps Curl, Dumbbell", "Bulgarian Split Squat", "Chin-up",
				"Dead Bench", "Deadlift, Barbell", "Deadlift, Romanian", "Deadlift, Stiff-legged", 
				"Deadlift, Trap Bar", "Deadlift, Deficit", 
				"Dip, Bench", "Dip, Parallel Bar", "Dip, Ring",
				"Face Pull, Cable", "Glute-Ham Raise", "Good Morning, Barbell",
				"Hammer Curl", "Hip Thrust, Barbell", "Lat Pull", "Lunge", "Pin Squat", "Power Clean",
				"Press, Barbell", "Press, Dumbbell", "Pull-up", "Rack Pull", "Reverse Hyper", 
				"Row, Barbell", "Row, Cable",
				"Row, Dumbbell", "Row, T-Bar", 
				"Skull Crusher", "Spoto Press", "Squat, Barbell", "Triceps Extension, Cable");
	ObservableList<String> bodyCompositionList = FXCollections.observableArrayList("Wilks Score", "Body Mass Index (BMI)", 
			"Body Fat Percentage", "Lean Body Mass", "Total Volume");
	ObservableList<String> heightInFeetList = FXCollections.observableArrayList("3 feet","4 feet", "5 feet", 
			"6 feet", "7 feet");
	ObservableList<String> heightInInchesList = FXCollections.observableArrayList("0 inches", "1 inch", 
			"2 inches", "3 inches", "4 inches", "5 inches", "6 inches", "7 inches", "8 inches", "9 inches",
			"10 inches", "11 inches");
	ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
		
	private TrainingLogController trainingLogController = new TrainingLogController();
	private ObservableList<WorkoutSetUI> setList = FXCollections.observableArrayList();
	
	private List<NewsArticle> articleList;
	private NewsArticleController articleController = new NewsArticleController();
	private List<String> searchHistoryList = new ArrayList<String>();
	
	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		addExercise.getItems().addAll(exerciseList);
		exerciseComboBox.getItems().addAll(exerciseList);
		bodyCompositionComboBox.getItems().addAll(bodyCompositionList);
		heightInFeetComboBox.getItems().addAll(heightInFeetList);
		heightInInchesComboBox.getItems().addAll(heightInInchesList);
		workoutTable.setItems(setList);
		genderComboBox.getItems().addAll(genderList);
		usernameTextField.setRestrict("[0-9 | a-z]");
		weightTextBox.setRestrict("-?((\\d*)|(\\d+\\.\\d*))");
		repsTextBox.setRestrict("[0-9]");
		workoutTab.setDisable(true);
		articlesTab.setDisable(true);
		measurementsTab.setDisable(true);
		statisticsTab.setDisable(true);
		
//		searchHistoryList.add("Test");
//		searchHistory.getItems().addAll(FXCollections.observableArrayList(searchHistoryList));
		
		try {
			loadArticleTabProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addSetButtonAction(ActionEvent event){
		String exer = addExercise.getValue();
		int rep = Integer.parseInt(repsTextBox.getText());
		double weight = Double.parseDouble(weightTextBox.getText());
		
		WorkoutSet workoutSet = new WorkoutSet();
		workoutSet.setExercise(exer);
		workoutSet.setRepCount(rep);
		workoutSet.setWeightLifted(weight);
		int set = trainingLogController.getSet();
		workoutSet.setSetNumber(set);
		trainingLogController.addWorkoutSet(workoutSet);
		
		WorkoutSetUI workoutUI = new WorkoutSetUI(set++, weight, rep, exer);
		setList.add(workoutUI);
	}
	
	@FXML
	public void saveWorkoutButtonAction(ActionEvent event){
		//IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("IplDb");
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("TestDb");
		trainingLogController.getWorkout().setWorkoutDate(java.sql.Date.valueOf(workoutDate.getValue()));//workoutDate.getValue());
		try {
			wDao.CreateWorkout(trainingLogController.getWorkout(), this.currentUser.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void loginAction(ActionEvent event){
		IAccountDAO aDao = AccountDaoFactory.GetAccountDAO("TestDb");
		try
		{
			this.currentUser = aDao.GetAccount(usernameTextField.getText(), passwordTextField.getText());
			if (this.currentUser != null)
			{
				workoutTab.setDisable(false);
				articlesTab.setDisable(false);
				measurementsTab.setDisable(false);
				statisticsTab.setDisable(false);
				settingsTab.setDisable(false);
				tcPnls.getSelectionModel().select(workoutTab);
				usernameTextField.setText("");
				passwordTextField.setText("");
				lblCurrentUser.setText("Current User: " + this.currentUser.getEmailAddress());
			}
			else
				lblCurrentUser.setText("Current User: Invalid Username and/or Password");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void registerAction(ActionEvent event){
		IAccountDAO aDao = AccountDaoFactory.GetAccountDAO("TestDb");
		this.currentUser = new Account();
		this.currentUser.setEmailAddress(usernameTextField.getText());
		this.currentUser.setPassword(passwordTextField.getText());
		try
		{
			this.currentUser = aDao.CreateAccount(this.currentUser);
			workoutTab.setDisable(false);
			articlesTab.setDisable(false);
			measurementsTab.setDisable(false);
			statisticsTab.setDisable(false);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void showFirstArticle(ActionEvent event){
		webView.getEngine().load(articleList.get(0).getSiteOrigin());
	}
	
	@FXML
	public void showSecondArticle(ActionEvent event){
		webView.getEngine().load(articleList.get(1).getSiteOrigin());
	}
	
	@FXML
	public void showThirdArticle(ActionEvent event){
		webView.getEngine().load(articleList.get(2).getSiteOrigin());
	}
	
	private void loadArticleTabProperties() throws Exception{
		articleList = articleController.retrieveNewsArticleList();
		if(articleList == null || articleList.isEmpty()) {
			throw new Exception();
		}
		
		article1.wrapTextProperty().setValue(true);
		article1.setAlignment(Pos.BASELINE_CENTER);
		article1.setText(articleList.get(0).getArticleTitle());
		webView.getEngine().load(articleList.get(0).getSiteOrigin());
		
		article2.wrapTextProperty().setValue(true);
		article2.setAlignment(Pos.BASELINE_CENTER);
		article2.setText(articleList.get(1).getArticleTitle());
		
		article3.wrapTextProperty().setValue(true);
		article3.setAlignment(Pos.BASELINE_CENTER);
		article3.setText(articleList.get(2).getArticleTitle());
	}
	
	@FXML
	public void searchArticlesAction(ActionEvent event){
		if(!searchTextBox.getText().equals("")){
			searchHistoryList.add(searchTextBox.getText());
		}
		searchHistory.setItems(FXCollections.observableArrayList(searchHistoryList));
	}
	
	@FXML
	public void showSearchHistory(ActionEvent event){
	}
	
	public void saveMeasurementsButtonAction(ActionEvent event){
		IMeasurementsDAO mDao = MeasurementsDaoFactory.GetMeasurementDAO("TestDb");
		double feet = Double.parseDouble(heightInFeetComboBox.getValue().split("[ ]")[0]);
		double inches = Double.parseDouble(heightInInchesComboBox.getValue().split("[ ]")[0]);
		double totalHeight = (feet * 12) + inches;
		
		ImperialMeasurement m = new ImperialMeasurement(totalHeight, Double.parseDouble(weightTextField.getText()), Double.parseDouble(waistTextField.getText()),0,0,0);
		m.setUserId(this.currentUser.getUserId());
		m.setMeasurementDate(java.sql.Date.valueOf(measurementsDate.getValue()));
		m.setNeck(0.0);
		try
		{
			mDao.CreateMeasurement(m);
			workoutTab.setDisable(false);
			articlesTab.setDisable(false);
			measurementsTab.setDisable(false);
			statisticsTab.setDisable(false);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}