package ru.avevdokimov.fxmaven11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    Stage FirstStage;
    @Override
    public void start(Stage FirstStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("views/main.fxml"));
        FirstStage.setTitle("Заготовка для приложения со многими сценами");
        FirstStage.setMinHeight(400);
        FirstStage.setMinWidth(600);
        FirstStage.setScene(new Scene(root, 900, 600));

        FirstStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}