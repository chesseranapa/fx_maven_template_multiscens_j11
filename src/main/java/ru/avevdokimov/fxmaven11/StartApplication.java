package ru.avevdokimov.fxmaven11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    Stage FirstStage;
    //получение всех загрузчиков из главного приложения для лучшего управления путями к *.fxml
    public final static FXMLLoader loaderScene01 = new FXMLLoader(StartApplication.class.getResource("views/scene01.fxml"));
    public final static FXMLLoader loaderScene02 = new FXMLLoader(StartApplication.class.getResource("views/scene02.fxml"));
    public final static FXMLLoader loaderForNewStage = new FXMLLoader(StartApplication.class.getResource("views/new_stage.fxml"));
    public final static FXMLLoader loaderForNewWindows = new FXMLLoader(StartApplication.class.getResource("views/new_w.fxml"));

    @Override
    public void start(Stage FirstStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
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