package com.psu.SWENG500.Powerlifting.controller;

import java.net.URL;
import java.awt.ScrollPane;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.border.Border;

import com.psu.SWENG500.Powerlifting.application.ui.RestrictiveTextField;
import com.psu.SWENG500.Powerlifting.application.ui.WheelNav;
import com.psu.SWENG500.Powerlifting.dal.AccountDaoFactory;
import com.psu.SWENG500.Powerlifting.dal.H2ConnectionFactory;
import com.psu.SWENG500.Powerlifting.dal.IAccountDAO;
import com.psu.SWENG500.Powerlifting.dal.IMeasurementsDAO;
import com.psu.SWENG500.Powerlifting.dal.IWorkoutDAO;
import com.psu.SWENG500.Powerlifting.dal.MeasurementsDaoFactory;
import com.psu.SWENG500.Powerlifting.dal.WorkoutDaoFactory;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;
import com.psu.SWENG500.Powerlifting.models.MeasurementType;
import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;
import com.psu.SWENG500.Powerlifting.models.ui.WorkoutSetUI;
import com.psu.SWENG500.Powerlifting.models.Account;
import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;
import com.psu.SWENG500.Powerlifting.models.TrainingLogModel;
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
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML
	private RestrictiveTextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Button loginButton;
	@FXML
	private ScrollBar workoutScrollBar;
	@FXML
	private TableView<WorkoutSetUI> workoutTable;
	@FXML
	private RestrictiveTextField weightTextBox;
	@FXML
	private RestrictiveTextField repsTextBox;
	@FXML
	private ComboBox<String> addExercise;
	@FXML
	private Button removeExercise;
	@FXML
	private Button addSet;
	@FXML
	private Button removeSet;
	@FXML
	private Button logWorkout;
	@FXML
	private DatePicker workoutDate;
	@FXML
	LineChart<String, Number> exerciseLineChart;
	@FXML
	LineChart<String, Number> bodyCompositionLineChart;
	@FXML
	private ComboBox<String> exerciseComboBox;
	@FXML
	private ComboBox<String> bodyCompositionComboBox;
	@FXML
	private TextField searchTextBox;
	@FXML
	private Button searchButton;
	@FXML
	private ComboBox<String> searchHistory;
	@FXML
	private WebView webView;
	@FXML
	private ScrollBar articleScrollBar;
	@FXML
	private Button article1;
	@FXML
	private Button article2;
	@FXML
	private Button article3;
	@FXML
	private Button refreshButton;
	@FXML
	private DatePicker measurementsDate;
	@FXML
	private ComboBox<String> heightInFeetComboBox;
	@FXML
	private ComboBox<String> heightInInchesComboBox;
	@FXML
	private TextField weightTextField;
	@FXML
	private TextField neckTextField;
	@FXML
	private TextField waistTextField;
	@FXML
	private Button saveMeasurementsButton;
	@FXML
	private Label loginErrorLabel;
	@FXML
	private Label workoutLogErrorLabel;
	@FXML
	private Label articleErrorLabel;
	@FXML
	private Label weightErrorLabel;
	@FXML
	private Label neckErrorLabel;
	@FXML
	private Label waistErrorLabel;
	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private Label usernameSetLabel;
	@FXML
	private Label saveUserLabel;
	@FXML
	private TextField passwordSetTextField;
	@FXML
	private Label genderLabel;
	@FXML
	private TextField rFirstNameTextField;
	@FXML
	private TextField rLastNameTextField;
	@FXML
	private TextField rEmailTextField;
	@FXML
	private RestrictiveTextField rUsernameSetTextField;
	@FXML
	private TextField rPasswordSetTextField;
	@FXML
	private ComboBox<String> rGenderComboBox;
	@FXML
	private Label lblCurrentUser;
	@FXML
	private Pane mainPane;
	@FXML
	private Pane workoutPane;
	@FXML
	private Pane statisticsPane;
	@FXML
	private Pane measurementPane;
	@FXML
	private Pane articlesPane;
	@FXML
	private WheelNav navWheelPane;
	@FXML
	private Pane settingsPane;
	@FXML
	private Pane registerPane;

	private Account currentUser;

	private boolean loggedIn = false;

	@FXML
	private TextField hipTextField;

	@FXML
	private TextField wristTextField;

	@FXML
	private TextField forearmTextField;

	@FXML
	ObservableList<String> exerciseList = FXCollections.observableArrayList(
			"Back Extension", "Bench Press, Barbell",
			"Bench Press, Close Grip", "Bench Press, Dumbbell",
			"Biceps Curl, Barbell", "Biceps Curl, Dumbbell",
			"Bulgarian Split Squat", "Chin-up", "Dead Bench",
			"Deadlift, Barbell", "Deadlift, Romanian",
			"Deadlift, Stiff-legged", "Deadlift, Trap Bar",
			"Deadlift, Deficit", "Dip, Bench", "Dip, Parallel Bar",
			"Dip, Ring", "Face Pull, Cable", "Glute-Ham Raise",
			"Good Morning, Barbell", "Hammer Curl", "Hip Thrust, Barbell",
			"Lat Pull", "Lunge", "Pin Squat", "Power Clean", "Press, Barbell",
			"Press, Dumbbell", "Pull-up", "Rack Pull", "Reverse Hyper",
			"Row, Barbell", "Row, Cable", "Row, Dumbbell", "Row, T-Bar",
			"Skull Crusher", "Spoto Press", "Squat, Barbell",
			"Triceps Extension, Cable");
	@FXML
	ObservableList<String> bodyCompositionList = FXCollections
			.observableArrayList("Wilks Score", "Body Mass Index (BMI)",
					"Body Fat Percentage", "Lean Body Mass", "Total Volume");
	@FXML
	ObservableList<String> heightInFeetList = FXCollections
			.observableArrayList("3 feet", "4 feet", "5 feet", "6 feet",
					"7 feet");
	@FXML
	ObservableList<String> heightInInchesList = FXCollections
			.observableArrayList("0 inches", "1 inch", "2 inches", "3 inches",
					"4 inches", "5 inches", "6 inches", "7 inches", "8 inches",
					"9 inches", "10 inches", "11 inches");
	@FXML
	ObservableList<String> genderList = FXCollections.observableArrayList(
			"Male", "Female");

	private TrainingLogController trainingLogController = new TrainingLogController();
	private TrainingLogModel trainingLog = new TrainingLogModel();
	private List<Measurements> userMeasurements = new ArrayList<Measurements>();
	private boolean refreshData = false;
	@FXML
	private ObservableList<WorkoutSetUI> setList = FXCollections
			.observableArrayList();

	private List<NewsArticle> articleList;
	private NewsArticleController articleController = new NewsArticleController();
	private List<String> searchHistoryList = new ArrayList<String>();
	private static final String DATABASE_LOCATION = "C:\\temp";

	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		File f = new File(DATABASE_LOCATION + "\\IplDb.mv.db");
		if (!f.exists())
			H2ConnectionFactory.InitializeDatabase();
		addExercise.getItems().addAll(exerciseList);
		exerciseComboBox.getItems().addAll(exerciseList);
		bodyCompositionComboBox.getItems().addAll(bodyCompositionList);
		heightInFeetComboBox.getItems().addAll(heightInFeetList);
		heightInInchesComboBox.getItems().addAll(heightInInchesList);
		workoutTable.setItems(setList);
		rGenderComboBox.getItems().addAll(genderList);
		usernameTextField.setRestrict("[0-9 | a-z | A-Z]");
		weightTextBox.setRestrict("-?((\\d*)|(\\d+\\.\\d*))");
		repsTextBox.setRestrict("[0-9]");

		settingsPane.setVisible(false);
		navWheelPane.setVisible(false);
		articlesPane.setVisible(false);
		statisticsPane.setVisible(false);
		measurementPane.setVisible(false);
		workoutPane.setVisible(false);
		registerPane.setVisible(false);
		
		bodyCompositionLineChart.setAnimated(false);
		exerciseLineChart.setAnimated(false);

		try {
			loadArticleTabProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void addSetButtonAction(ActionEvent event) {
		String exer = addExercise.getValue();
		try {
			Integer rep = Integer.parseInt(repsTextBox.getText());
			Double weight = Double.parseDouble(weightTextBox.getText());
			if (exer != null && !exer.isEmpty() && rep != null
					&& weight != null) {
				WorkoutSet workoutSet = new WorkoutSet();
				workoutSet.setExercise(exer);
				workoutSet.setRepCount(rep);
				workoutSet.setWeightLifted(weight);
				try {
					trainingLogController.getSet();
				} catch (NullPointerException e) {
					System.out.println("training Controller null" + e);
				}
				int set = trainingLogController.getSet();
				workoutSet.setSetNumber(set);
				trainingLogController.addWorkoutSet(workoutSet);

				WorkoutSetUI workoutUI = new WorkoutSetUI(set++, weight, rep,
						exer);
				setList.add(workoutUI);
			} else if (exer.isEmpty()) {
				// TODO
			}
		} catch (NumberFormatException e) {
			// log exception
		}
	}

	@FXML
	public void saveWorkoutButtonAction(ActionEvent event) {
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO(DATABASE_LOCATION);
		trainingLogController.getWorkout().setWorkoutDate(
				java.sql.Date.valueOf(workoutDate.getValue()));
		try {
			wDao.CreateWorkout(trainingLogController.getWorkout(),
					this.currentUser.getUserId());
			this.refreshData = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void loginAction(ActionEvent event) {
		IAccountDAO aDao = AccountDaoFactory.GetAccountDAO(DATABASE_LOCATION);
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO(DATABASE_LOCATION);
		IMeasurementsDAO mDao = MeasurementsDaoFactory
				.GetMeasurementDAO(DATABASE_LOCATION);
		if (usernameTextField.getText().equals("")) {
			loginErrorLabel.setText("Enter your username");
			return;
		}
		if (passwordTextField.getText().equals("")) {
			loginErrorLabel.setText("Enter your password");
			return;
		}
		try {
			this.currentUser = aDao.GetAccount(usernameTextField.getText(),
					passwordTextField.getText());
			if (this.currentUser != null) {
				usernameTextField.setText("");
				passwordTextField.setText("");
				lblCurrentUser.setText("Current User: "
						+ this.currentUser.getNickname());
				trainingLog = new TrainingLogModel(
						wDao.GetWorkouts(this.currentUser.getUserId()));
				this.userMeasurements = mDao.GetMeasurements(this.currentUser
						.getUserId());
				loggedIn = true;

				navWheelPane.loadGraphics(currentUser, usernameSetLabel,
						firstNameTextField, lastNameTextField, emailTextField,
						genderLabel, settingsPane, articlesPane,
						measurementPane, navWheelPane, statisticsPane,
						workoutPane);
				navWheelPane.setVisible(true);
				mainPane.setVisible(false);

				this.refreshData = false;
			} else
			{
				loginErrorLabel.setText(usernameTextField.getText()
						+ " has not registered");
				lblCurrentUser
					.setText("Current User: Invalid Username and/or Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void logoutAction(ActionEvent event)
	{
		lblCurrentUser.setText("Current User: [Nobody logged in]");
		loginErrorLabel.setText("");
		bodyCompositionLineChart.getData().clear();
		exerciseLineChart.getData().clear();
		
		setList.clear();
		
		usernameSetLabel.setText("");
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		emailTextField.setText("");
		genderLabel.setText("");
		
		this.currentUser = null;
		this.trainingLog = null;
		this.userMeasurements = null;
		settingsPane.setVisible(false);
		navWheelPane.setVisible(false);
		articlesPane.setVisible(false);
		statisticsPane.setVisible(false);
		measurementPane.setVisible(false);
		workoutPane.setVisible(false);
		registerPane.setVisible(false);
		mainPane.setVisible(true);
	}

	@FXML
	public void registerAction(ActionEvent event) {
		mainPane.setVisible(false);
		registerPane.setVisible(true);
	}

	@FXML
	public void showFirstArticle(ActionEvent event) {
		searchTextBox.setText("");
		webView.getEngine().load(articleList.get(0).getSiteOrigin());
	}

	@FXML
	public void showSecondArticle(ActionEvent event) {
		searchTextBox.setText("");
		webView.getEngine().load(articleList.get(1).getSiteOrigin());
	}

	@FXML
	public void showThirdArticle(ActionEvent event) {
		searchTextBox.setText("");
		webView.getEngine().load(articleList.get(2).getSiteOrigin());
	}

	private void loadArticleTabProperties() throws Exception {
		searchTextBox.setText("");
		articleList = articleController.retrieveNewsArticleList();
		if (articleList == null || articleList.isEmpty()) {
			throw new Exception();
		}
		setFirstArticleButton(articleList.get(0));
		setSecondArticleButton(articleList.get(1));
		setThirdArticleButton(articleList.get(2));
	}

	private void setFirstArticleButton(NewsArticle newsArticle) {
		if (article1.isDisable()) {
			article1.setDisable(false);
		}
		article1.wrapTextProperty().setValue(true);
		article1.setAlignment(Pos.BASELINE_CENTER);
		article1.setText(newsArticle.getArticleTitle());
		webView.getEngine().load(newsArticle.getSiteOrigin());
	}

	private void setSecondArticleButton(NewsArticle newsArticle) {
		if (article2.isDisable()) {
			article2.setDisable(false);
		}
		article2.wrapTextProperty().setValue(true);
		article2.setAlignment(Pos.BASELINE_CENTER);
		article2.setText(newsArticle.getArticleTitle());
	}

	private void setThirdArticleButton(NewsArticle newsArticle) {
		if (article3.isDisable()) {
			article3.setDisable(false);
		}
		article3.wrapTextProperty().setValue(true);
		article3.setAlignment(Pos.BASELINE_CENTER);
		article3.setText(newsArticle.getArticleTitle());
	}

	private void disableFirstArticleButton() {
		article1.setText("");
		article1.setDisable(true);
	}

	private void disableSecondArticleButton() {
		article2.setText("");
		article2.setDisable(true);
	}

	private void disableThirdArticleButton() {
		article3.setText("");
		article3.setDisable(true);
	}

	private void clearArticleErrorLabel() {
		articleErrorLabel.setText("");
	}

	@FXML
	public void searchArticlesAction(ActionEvent event) {
		clearArticleErrorLabel();
		if (!searchTextBox.getText().equals("")) {
			searchHistoryList.add(0, searchTextBox.getText());
			searchHistory.setItems(FXCollections
					.observableArrayList(searchHistoryList));
			boolean successfulSearch = searchArticles(searchTextBox.getText());
			searchTextBox.setText("");
			if (!successfulSearch) {
				articleErrorLabel.setText("No articles found");
			}
		}
	}

	@FXML
	public void showSearchHistory(ActionEvent event) {
		clearArticleErrorLabel();
		boolean successfulSearch = searchArticles(searchHistory.getValue());
		searchTextBox.setText("");
		if (!successfulSearch) {
			articleErrorLabel.setText("No articles found");
		}
	}

	private boolean searchArticles(String searchString) {
		clearArticleErrorLabel();
		List<NewsArticle> searchArticleList = articleController
				.searchArticles(searchString);
		if (searchArticleList.size() != 0) {
			setFirstArticleButton(searchArticleList.get(0));
			if (searchArticleList.size() >= 2) {
				setSecondArticleButton(searchArticleList.get(1));
				if (searchArticleList.size() >= 3) {
					setThirdArticleButton(searchArticleList.get(2));
				} else {
					disableThirdArticleButton();
				}
			} else {
				disableSecondArticleButton();
				disableThirdArticleButton();
			}
		} else {
			return false;
		}
		return true;
	}

	@FXML
	public void refreshNewsArticles(ActionEvent event) throws Exception {
		searchTextBox.setText("");
		clearArticleErrorLabel();
		loadArticleTabProperties();
	}

	@FXML
	public void saveMeasurementsButtonAction(ActionEvent event) {
		IMeasurementsDAO mDao = MeasurementsDaoFactory
				.GetMeasurementDAO(DATABASE_LOCATION);
		double feet = Double.parseDouble(heightInFeetComboBox.getValue().split(
				"[ ]")[0]);
		double inches = Double.parseDouble(heightInInchesComboBox.getValue()
				.split("[ ]")[0]);
		double totalHeight = (feet * 12) + inches;

		double weight = Double.parseDouble(weightTextField.getText());

		double waist = Double.parseDouble(waistTextField.getText());

		double neckSize = Double.parseDouble(neckTextField.getText());

		double hipSize = Double.parseDouble(hipTextField.getText());

		double wristSize = Double.parseDouble(wristTextField.getText());

		double forearmSize = Double.parseDouble(forearmTextField.getText());

		ImperialMeasurement m = new ImperialMeasurement(totalHeight, weight,
				waist, wristSize, hipSize, forearmSize);
		m.setUserId(this.currentUser.getUserId());
		m.setMeasurementDate(java.sql.Date.valueOf(measurementsDate.getValue()));
		m.setNeck(neckSize);
		try {
			mDao.CreateMeasurement(m);
			this.refreshData = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void saveUserButtonAction(ActionEvent event) {
		if (validateString(rUsernameSetTextField.getText())
				&& validateString(rPasswordSetTextField.getText())
				&& validateString(rFirstNameTextField.getText())
				&& validateString(rLastNameTextField.getText())
				&& validateString(rEmailTextField.getText())
				&& validateGender(rGenderComboBox.getValue())) {

			IAccountDAO aDao = AccountDaoFactory
					.GetAccountDAO(DATABASE_LOCATION);
			this.currentUser = new Account();
			this.currentUser.setNickname(rUsernameSetTextField.getText());
			this.currentUser.setPassword(rPasswordSetTextField.getText());
			this.currentUser.setFirstName(rFirstNameTextField.getText());
			this.currentUser.setLastName(rLastNameTextField.getText());
			this.currentUser.setEmailAddress(rEmailTextField.getText());
			this.currentUser.setGender(rGenderComboBox.getValue());
			try {
				this.currentUser = aDao.CreateAccount(this.currentUser);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			navWheelPane.loadGraphics(currentUser, usernameSetLabel,
					firstNameTextField, lastNameTextField, emailTextField,
					genderLabel, settingsPane, articlesPane, measurementPane,
					navWheelPane, statisticsPane, workoutPane);
			registerPane.setVisible(false);
			navWheelPane.setVisible(true);

			lblCurrentUser.setText("Current User: "
					+ this.currentUser.getNickname());

			loggedIn = true;
		} else {
			saveUserLabel.setText("Not all fields are filled out");
		}
	}

	@FXML
	public void saveSettingsButtonAction(ActionEvent event) {
		this.currentUser.setPassword(passwordSetTextField.getText());
		this.currentUser.setFirstName(firstNameTextField.getText());
		this.currentUser.setLastName(lastNameTextField.getText());
		this.currentUser.setEmailAddress(emailTextField.getText());

		IAccountDAO aDao = AccountDaoFactory.GetAccountDAO(DATABASE_LOCATION);
		try {
			aDao.UpdateAccount(this.currentUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		settingsPane.setVisible(false);
		navWheelPane.setVisible(true);
	}

	@FXML
	public void workoutDateChanged(ActionEvent event) {
		checkDataCache();

		try {
			Workout selectedWorkout = trainingLog
					.GetWorkout(new SimpleDateFormat("yyyy-MM-dd").parse(String
							.valueOf(workoutDate.getValue())));
			trainingLogController.setWorkout(selectedWorkout);
			setList.clear();
			if (selectedWorkout != null) {
				for (WorkoutSet ws : trainingLogController.getWorkout()
						.GetWorkoutSets()) {
					WorkoutSetUI workoutUI = new WorkoutSetUI(
							ws.getSetNumber(), ws.getWeightLifted(),
							ws.getRepCount(), ws.getExerciseName());
					setList.add(workoutUI);
				}
			} else {
				Workout w = new Workout();
				w.setWorkoutDate(new SimpleDateFormat("yyyy-MM-dd")
						.parse(String.valueOf(workoutDate.getValue())));
				trainingLogController.setWorkout(w);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	public void exerciseChanged(ActionEvent event) {
		checkDataCache();
		exerciseLineChart.getData().clear();
		XYChart.Series series = new XYChart.Series();
		series.setName(exerciseComboBox.getValue());
		List<Workout> tempWorkouts = this.trainingLog
				.GetWorkoutsByExercise(exerciseComboBox.getValue());
		for (Workout w : tempWorkouts) {
			double weightLifted = w.getMaxVolumeByExercise(exerciseComboBox
					.getValue());
			String dateString = new SimpleDateFormat("MM/dd/yyyy").format(w
					.getWorkoutDate());
			series.getData().add(new XYChart.Data(dateString, weightLifted));
		}
		exerciseLineChart.getData().add(series);
	}

	@FXML
	public void bodyCompositionChanged(ActionEvent event) {
		checkDataCache();
		CalculatorController cc = new CalculatorController();
		bodyCompositionLineChart.getData().clear();
		XYChart.Series series = new XYChart.Series();
		
		int selectedStatistic = bodyCompositionComboBox.getSelectionModel()
				.getSelectedIndex();
		switch (selectedStatistic) {
		case 0:
			for (Measurements m : this.userMeasurements) {
				Workout tempWorkout = this.trainingLog.GetWorkout(m
						.getMeasurementDate());
				if (tempWorkout != null) {
					double wilks = cc.calculateWilks(m, tempWorkout
							.getWilksVolume(), this.currentUser.getGender()
							.equals("Male") ? true : false);
					String dateString = new SimpleDateFormat("MM/dd/yyyy")
							.format(m.getMeasurementDate());
					series.getData().add(new XYChart.Data(dateString, wilks));
				}
			}
			break;
		case 1:
			for (Measurements m : this.userMeasurements) {
				double bmi = cc.calculateBodyMassIndex(m);
				String dateString = new SimpleDateFormat("MM/dd/yyyy").format(m
						.getMeasurementDate());
				series.getData().add(new XYChart.Data(dateString, bmi));
			}
			break;
		case 2:
			for (Measurements m : this.userMeasurements) {
				boolean tempIsMale = this.currentUser.getGender().equals("Male") ? true
						: false;
				double bfp = cc.calculateBodyFatPercentage(m, tempIsMale);
				String dateString = new SimpleDateFormat("MM/dd/yyyy").format(m
						.getMeasurementDate());
				series.getData().add(new XYChart.Data(dateString, bfp));
			}
			break;
		case 3:
			for (Measurements m : this.userMeasurements) {
				boolean tempIsMale = this.currentUser.getGender().equals("Male") ? true
						: false;
				double lbm = cc.calculateLeanBodyMass(m, tempIsMale);
				String dateString = new SimpleDateFormat("MM/dd/yyyy").format(m
						.getMeasurementDate());
				series.getData().add(new XYChart.Data(dateString, lbm));
			}
			break;
		case 4:
			List<Workout> tempWorkouts = this.trainingLog.GetWorkouts();
			for (Workout w : tempWorkouts) {
				double weightLifted = w.getTotalVolume();
				String dateString = new SimpleDateFormat("MM/dd/yyyy").format(w
						.getWorkoutDate());
				series.getData()
						.add(new XYChart.Data(dateString, weightLifted));
			}
			break;
		}
		series.setName(bodyCompositionComboBox.getValue());
		bodyCompositionLineChart.getData().add(series);
	}

	@FXML
	public void rightClick(MouseEvent event) {
		if (!loggedIn) {
			return;
		}
		if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
			navWheelPane.setVisible(true);
			articlesPane.setVisible(false);
			measurementPane.setVisible(false);
			statisticsPane.setVisible(false);
			workoutPane.setVisible(false);
			settingsPane.setVisible(false);
		}
	}

	private boolean validateString(String entry) {
		if (entry != null) {
			if (!entry.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private boolean validateGender(String gender) {
		if (gender != null) {
			if (!gender.isEmpty()) {
				if (gender.equals("Male") || gender.equals("Female")) {
					return true;
				}
			}
		}
		return false;
	}

	private void checkDataCache() {
		if (this.refreshData) {
			try {
				IWorkoutDAO wDao = WorkoutDaoFactory
						.GetWorkoutDAO(DATABASE_LOCATION);
				IMeasurementsDAO mDao = MeasurementsDaoFactory
						.GetMeasurementDAO(DATABASE_LOCATION);
				this.trainingLog = new TrainingLogModel(
						wDao.GetWorkouts(this.currentUser.getUserId()));
				this.userMeasurements = mDao.GetMeasurements(this.currentUser
						.getUserId());
				this.refreshData = false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}