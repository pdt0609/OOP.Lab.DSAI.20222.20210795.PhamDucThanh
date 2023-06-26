package In_class_exercises;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowDateTime extends Application {

    private TextField dateTimeField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Date Time Application");

        // Create a text field to display the date and time
        dateTimeField = new TextField();
        dateTimeField.setEditable(false);

        // Create a button to show the date and time
        Button showDateTimeButton = new Button("Show Date Time");
        showDateTimeButton.setOnAction(e -> showDateTime());

        // Create a layout and add the text field and button to it
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(dateTimeField, showDateTimeButton);

        // Create a scene with the layout
        Scene scene = new Scene(layout, 300, 150);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time using a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Set the formatted date and time to the text field
        dateTimeField.setText(formattedDateTime);
    }
}