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

    private MainController mc;

    public void tf01OnAction(){
        System.out.println("Во второй сцене, поле 1");
        tf01.setText("Во второй сцене, поле 1");
    }

    public void setTf01(String text) {
        tf01.setText(text);
        mc.lbLeftStatus.setText("из второй сцены вызов setTf01");
    }

    public void tf02OnAction(){
        System.out.println("Во второй сцене, поле 2");
    }

    public void setOutController(MainController mc){
        this.mc = mc;
    }

    /**
     * Инициализация контроллера
     */
    @FXML
    private void initialize() {

    }

}


