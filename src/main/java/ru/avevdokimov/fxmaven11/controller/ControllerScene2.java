package ru.avevdokimov.fxmaven11.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * контроллер первой сцены (элементы определены в файле *.fxml
 *
 * @author AVEvdokimov
 */
public class ControllerScene2 {

    @FXML
    TextField tf01;

    @FXML
    TextField tf02;

    public void tf01OnAction(){
        System.out.println("Во второй сцене, поле 1");

    }

    public void tf02OnAction(){
        System.out.println("Во второй сцене, поле 2");

    }

    /**
     * Инициализация контроллера
     */
    @FXML
    private void initialize() {

    }

}


