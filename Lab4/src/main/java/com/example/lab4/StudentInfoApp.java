package com.example.lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashSet;

public class StudentInfoApp extends Application {

    private ComboBox<String> courseComboBox;
    private ListView<String> courseListView;
    private HashSet<String> selectedCourses;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Input Fields
        TextField fullNameField = new TextField();
        TextField addressField = new TextField();
        TextField cityField = new TextField();
        TextField provinceField = new TextField();
        TextField postalCodeField = new TextField();
        TextField phoneField = new TextField();
        TextField emailField = new TextField();

        // Radio Buttons for Major
        ToggleGroup majorGroup = new ToggleGroup();
        RadioButton csButton = new RadioButton("Computer Science");
        RadioButton businessButton = new RadioButton("Business");
        csButton.setToggleGroup(majorGroup);
        businessButton.setToggleGroup(majorGroup);

        // ComboBox for Courses
        courseComboBox = new ComboBox<>();
        courseListView = new ListView<>();
        selectedCourses = new HashSet<>();

        // Update ComboBox based on selected major
        csButton.setOnAction(e -> updateCourses("Computer Science"));
        businessButton.setOnAction(e -> updateCourses("Business"));

        // Add course to ListView
        Button addCourseButton = new Button("Add Course");
        addCourseButton.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !selectedCourses.contains(selectedCourse)) {
                selectedCourses.add(selectedCourse);
                courseListView.getItems().add(selectedCourse);
            }
        });

        // CheckBoxes for Additional Info
        CheckBox sportsCheckBox = new CheckBox("Sports");
        CheckBox musicCheckBox = new CheckBox("Music");
        CheckBox volunteeringCheckBox = new CheckBox("Volunteering");

        // Display Area
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String major = ((RadioButton) majorGroup.getSelectedToggle()).getText();
            String additionalInfo = (sportsCheckBox.isSelected() ? "Sports " : "") +
                    (musicCheckBox.isSelected() ? "Music " : "") +
                    (volunteeringCheckBox.isSelected() ? "Volunteering" : "");

            String studentInfo = String.format(
                    "Name: %s\nAddress: %s, %s, %s, %s\nPhone: %s\nEmail: %s\nMajor: %s\nCourses: %s\nActivities: %s",
                    fullNameField.getText(), addressField.getText(), cityField.getText(), provinceField.getText(),
                    postalCodeField.getText(), phoneField.getText(), emailField.getText(), major, selectedCourses, additionalInfo
            );

            displayArea.setText(studentInfo);
        });

        // Layout
        GridPane inputPane = new GridPane();
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.setPadding(new Insets(10));
        inputPane.add(new Label("Full Name:"), 0, 0);
        inputPane.add(fullNameField, 1, 0);
        inputPane.add(new Label("Address:"), 0, 1);
        inputPane.add(addressField, 1, 1);
        inputPane.add(new Label("City:"), 0, 2);
        inputPane.add(cityField, 1, 2);
        inputPane.add(new Label("Province:"), 0, 3);
        inputPane.add(provinceField, 1, 3);
        inputPane.add(new Label("Postal Code:"), 0, 4);
        inputPane.add(postalCodeField, 1, 4);
        inputPane.add(new Label("Phone:"), 0, 5);
        inputPane.add(phoneField, 1, 5);
        inputPane.add(new Label("Email:"), 0, 6);
        inputPane.add(emailField, 1, 6);
        inputPane.add(new Label("Major:"), 0, 7);
        inputPane.add(new VBox(5, csButton, businessButton), 1, 7);

        VBox coursePane = new VBox(10, courseComboBox, addCourseButton, new Label("Selected Courses:"), courseListView);
        VBox activitiesPane = new VBox(5, sportsCheckBox, musicCheckBox, volunteeringCheckBox);

        BorderPane root = new BorderPane();
        root.setTop(inputPane);
        root.setCenter(coursePane);
        root.setRight(activitiesPane);
        root.setBottom(new VBox(10, submitButton, displayArea));

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Student Information Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCourses(String major) {
        courseComboBox.getItems().clear();
        if ("Computer Science".equals(major)) {
            courseComboBox.getItems().addAll("Algorithms", "Data Structures", "Operating Systems", "Databases");
        } else if ("Business".equals(major)) {
            courseComboBox.getItems().addAll("Marketing", "Finance", "Management", "Accounting");
        }
    }
}
