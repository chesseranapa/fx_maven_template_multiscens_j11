package ru.avevdokimov.fxmaven11;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.avevdokimov.fxmaven11.controller.ControllerScene1;

import java.io.IOException;

/**
 * Основной контроллер (элементы определены в файле main.fxml
 *
 * @author AVEvdokimov
 */
public class MainController {

    //Создаём два различных загрузчика для центрального окна
    FXMLLoader loaderScene01 = new FXMLLoader(getClass().getResource("views/scene01.fxml"));
    FXMLLoader loaderScene02 = new FXMLLoader(getClass().getResource("views/scene02.fxml"));


    @FXML
    MenuItem fItem;

    @FXML
    MenuItem sItem;

    @FXML
    MenuItem nwItem;

    @FXML
    Label lb03;

    @FXML
    public
    Label lbLeftStatus;

    @FXML
    Label lbRightStatus;

    @FXML
    Pane mainPane;

    @FXML
    AnchorPane mainAnchorPane;


    private void loadProperties() throws IOException {//Загрузка свойств вынесено в отдельную процедуру для использования при инициализации
        //node1 = loaderScene01.load(getClass().getResource("/views/scene01.fxml"));
        //node2 = loaderScene02.load(getClass().getResource("/views/scene02.fxml"));
        //mainAnchorPane.getChildren().setAll(node1);

        //FXMLLoader loaderScene01 = new FXMLLoader(getClass().getResource("/views/scene01.fxml"));
        //mainAnchorPane = (AnchorPane)loaderScene01.load();

        //Производим загрузку из указанных ранее файлов (нужно сделать обработчик ошибок)
        loaderScene01.load();
        loaderScene02.load();

        //для именнованной в главном файле и внедрённой в этот контроллер панели
        //устанавливаем элементы из корневого элемента первого загрузчкика
        mainAnchorPane.getChildren().setAll((Node)loaderScene01.getRoot());


        //вызов  процедуры для установки единственного интервала для нулевого нода якорной панели
        setAllIntervalsUnicumNodeForAPane(mainAnchorPane, 3.0);


    }

    public void getFirstScenr() throws Exception {

        //для именнованной в главном файле и внедрённой в этот контроллер панели
        //устанавливаем элементы из корневого элемента первого загрузчкика
        //так как не вызывали предварительную загрузку, то, при повторных использованиях она
        //не загружается, а используется ранее загруженная со всеми сделанными при работе программы
        //изменениями
        mainAnchorPane.getChildren().setAll((Node)loaderScene01.getRoot());


        setAllIntervalsUnicumNodeForAPane(mainAnchorPane, 3.0);



        //mainAnchorPane = (AnchorPane)loaderScene01.load();

        //Получаем контроллер для из первого загрузчика
        ControllerScene1 controller =  loaderScene01.<ControllerScene1>getController();

        controller.setOutController(this);

        //ВЫзов тестового метода из контроллера первого загрузчика
        controller.set_tf01("testcdsc");

    }

    public void setAllIntervalsUnicumNodeForAPane(AnchorPane aPane, double interval)  {
        Node node = aPane.getChildren().get(0);
        aPane.setRightAnchor(node, interval);
        aPane.setLeftAnchor(node, interval);
        aPane.setBottomAnchor(node, interval);
        aPane.setTopAnchor(node, interval);
    }



    //Пример открытия нового окна с вызовом метода из его контроллера для передачи в него параметров
    public void showCustomerDialog() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("views/new_stage.fxml")
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        AnchorPane aPane = (AnchorPane)loader.load(); //Инициируем загрузку и сразу получаем панель для создания сцены
        setAllIntervalsUnicumNodeForAPane(aPane, 10.0);
        stage.setScene(
                new Scene(aPane ,800,400) );

        ControllerScene1 controller =
                loader.<ControllerScene1>getController(); //Получение контроллера из загрузчика
        controller.set_tf01("test"); //Вызов процедуры загрузчика (передаём текст в поле сцены)
        stage.sizeToScene();
        //stage.setResizable(true);

        //Можем задать действия при закрытии
        stage.setOnCloseRequest(e->{

            lbLeftStatus.setText("Ура"); //простое действие
            lbRightStatus.setText(controller.tf01.getText()); //забираем параметр из подчинённого окна
        });
        stage.initModality(Modality.APPLICATION_MODAL); //запрещаем работу с другими окнами этого приложения, пока не закончим с этим
        stage.show();

        //return stage;
    }




    public void getSecondScenr() throws Exception {
        mainAnchorPane.getChildren().setAll((Node)loaderScene02.getRoot());
        setAllIntervalsUnicumNodeForAPane(mainAnchorPane, 3.0);
    }

    public void getNewWindows() throws Exception {
        Stage newWindows = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("views/new_w.fxml"));
        newWindows.setTitle("Новое окно");
        newWindows.setUserData("test");
        newWindows.setMinHeight(400);
        newWindows.setMinWidth(600);
        newWindows.setScene(new Scene(root, 900, 600));
        newWindows.initModality(Modality.APPLICATION_MODAL);

        //initOwner(parentStage);
        newWindows.show();



    }

    public void bt01OnClick() {// Зарезервировано под Клик на соответствуюещей кнопке
        // System.out.println("testbt01");

    }

    public double shiftLeft(double x) {
        double t = x;
        if (t < 250) {
            return t + 25;
        }
        return 25;
    }

    /**
     * Инициализация контроллера
     *
     * @throws Exception
     */
    @FXML
    private void initialize() throws Exception {

        loadProperties();

    }

}