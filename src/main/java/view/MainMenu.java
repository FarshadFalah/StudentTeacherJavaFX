package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.database.DatabaseManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class MainMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane =new Pane();
        Scene scene=new Scene(pane,500,100,true, SceneAntialiasing.BALANCED);
        primaryStage.setTitle("Main Menu");
        HBox hBox=new HBox();
        pane.getChildren().add(hBox);
        Text text=new Text();
        Button studentButton=new Button("Student");
        Button teacherButton=new Button("Teacher");
        Button courseButton=new Button("Course");
        hBox.getChildren().add(studentButton);
        hBox.getChildren().add(teacherButton);
        hBox.getChildren().add(courseButton);
        hBox.setPadding(new Insets(10,10,10,10));
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            DatabaseManager databaseManager=DatabaseManager.getInstance();
            Connection connection=databaseManager.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
