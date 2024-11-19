import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

public class StudentInfoApp extends Application {

    // Declare UI components
    private TextField fullNameField, addressField, cityField, provinceField, postalCodeField, phoneField, emailField;
    private RadioButton csRadioButton, businessRadioButton;
    private ComboBox<String> coursesComboBox;
    private ListView<String> coursesListView;
    private TextArea studentInfoArea;
    private Set<String> selectedCourses = new HashSet<>();
    private CheckBox activity1CheckBox, activity2CheckBox, activity3CheckBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information Entry");

        // Create layout panes
        GridPane formPane = createFormPane();
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(formPane);

        // Display area
        studentInfoArea = new TextArea();
        studentInfoArea.setEditable(false);
        studentInfoArea.setPrefHeight(200);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> displayStudentInfo());

        VBox bottomBox = new VBox(10, studentInfoArea, submitButton);
        bottomBox.setPadding(new Insets(10));
        root.setBottom(bottomBox);

        // Set up the scene and stage
        Scene scene = new Scene(root, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Text fields for student information
        fullNameField = new TextField();
        addressField = new TextField();
        cityField = new TextField();
        provinceField = new TextField();
        postalCodeField = new TextField();
        phoneField = new TextField();
        emailField = new TextField();

        // Radio buttons for major selection
        csRadioButton = new RadioButton("Computer Science");
        businessRadioButton = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csRadioButton.setToggleGroup(majorGroup);
        businessRadioButton.setToggleGroup(majorGroup);
        csRadioButton.setOnAction(e -> updateCourses("Computer Science"));
        businessRadioButton.setOnAction(e -> updateCourses("Business"));

        // Combo box for course selection and list view for selected courses
        coursesComboBox = new ComboBox<>();
        coursesListView = new ListView<>();
        Button addCourseButton = new Button("Add Course");
        addCourseButton.setOnAction(e -> addCourse());

        // Check boxes for additional information
        activity1CheckBox = new CheckBox("Sports");
        activity2CheckBox = new CheckBox("Music");
        activity3CheckBox = new CheckBox("Art Club");

        // Adding components to GridPane
        gridPane.add(new Label("Full Name:"), 0, 0);
        gridPane.add(fullNameField, 1, 0);
        gridPane.add(new Label("Address:"), 0, 1);
        gridPane.add(addressField, 1, 1);
        gridPane.add(new Label("City:"), 0, 2);
        gridPane.add(cityField, 1, 2);
        gridPane.add(new Label("Province:"), 0, 3);
        gridPane.add(provinceField, 1, 3);
        gridPane.add(new Label("Postal Code:"), 0, 4);
        gridPane.add(postalCodeField, 1, 4);
        gridPane.add(new Label("Phone:"), 0, 5);
        gridPane.add(phoneField, 1, 5);
        gridPane.add(new Label("Email:"), 0, 6);
        gridPane.add(emailField, 1, 6);

        gridPane.add(new Label("Major:"), 0, 7);
        HBox majorBox = new HBox(10, csRadioButton, businessRadioButton);
        gridPane.add(majorBox, 1, 7);

        gridPane.add(new Label("Courses:"), 0, 8);
        VBox courseBox = new VBox(10, coursesComboBox, addCourseButton, coursesListView);
        gridPane.add(courseBox, 1, 8);

        gridPane.add(new Label("Activities:"), 0, 9);
        VBox activityBox = new VBox(10, activity1CheckBox, activity2CheckBox, activity3CheckBox);
        gridPane.add(activityBox, 1, 9);

        return gridPane;
    }

    private void updateCourses(String major) {
        coursesComboBox.getItems().clear();
        if (major.equals("Computer Science")) {
            coursesComboBox.getItems().addAll("Data Structures", "Algorithms", "Database Systems", "Operating Systems");
        } else if (major.equals("Business")) {
            coursesComboBox.getItems().addAll("Accounting", "Marketing", "Finance", "Management");
        }
    }

    private void addCourse() {
        String selectedCourse = coursesComboBox.getValue();
        if (selectedCourse != null && !selectedCourses.contains(selectedCourse)) {
            selectedCourses.add(selectedCourse);
            coursesListView.getItems().add(selectedCourse);
        }
    }

    private void displayStudentInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Student Information:\n")
                .append("Name: ").append(fullNameField.getText()).append("\n")
                .append("Address: ").append(addressField.getText()).append(", ")
                .append(cityField.getText()).append(", ")
                .append(provinceField.getText()).append(", ")
                .append(postalCodeField.getText()).append("\n")
                .append("Phone: ").append(phoneField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n");

        if (csRadioButton.isSelected()) {
            info.append("Major: Computer Science\n");
        } else if (businessRadioButton.isSelected()) {
            info.append("Major: Business\n");
        }

        info.append("Courses: ").append(String.join(", ", selectedCourses)).append("\n");

        info.append("Activities: ");
        if (activity1CheckBox.isSelected()) info.append("Sports ");
        if (activity2CheckBox.isSelected()) info.append("Music ");
        if (activity3CheckBox.isSelected()) info.append("Art Club ");
        info.append("\n");

        studentInfoArea.setText(info.toString());
    }
}
