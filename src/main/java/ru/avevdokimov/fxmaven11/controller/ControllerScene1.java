package ru.avevdokimov.fxmaven11.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * контроллер первой сцены (элементы определены в файле *.fxml
 *
 * @author AVEvdokimov
 */
public class ControllerScene1 {

    private MainController mc;

    @FXML
    public TextField tf01;


    public void tf01OnAction(){
        System.out.println("В первой сцене");
        tf01.setText("В первой сцене");
        mc.lbLeftStatus.setText("В первой сцене");
    }

    public void set_tf01(String str){
        System.out.println("тест вызова из основного контролера");
        tf01.setText(str);
        if(mc!=null) {
            mc.lbLeftStatus.setText("utro");
        }
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

