/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.ProcessCal;

/**
 *
 * @author kOX
 */
public class ProcessMan extends Application {
    
    public static LogTableView table;   
    public static TableView view;         //log视图
    public static PCBTableView tt;
    public static TableView tv;             //线程视图
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("单处理调度系统v2.0");
        Scene scene = new Scene(new VBox(), 500, 700);
        MenuEdit menuEdit= new MenuEdit(); 
        MenuBar  menuBar = menuEdit.addMenu();


        /////这里新建类吧
        table = new LogTableView();            
        view = table.addTableView();    
        
        tt = new PCBTableView();
        tv = tt.addTableView();


        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setFitToWidth(true);
        scrollpane.setFitToHeight(true);
        scrollpane.setPrefSize(500, 400);
        scrollpane.setContent(view);

        ScrollPane dscrollpane = new ScrollPane();
        dscrollpane.setFitToWidth(true);
        dscrollpane.setFitToHeight(true);
        dscrollpane.setPrefSize(500, 200);
        dscrollpane.setContent(tv);

        HBox buttonBar = ButtonBar.initBar();
        
        //窗口退出时关闭线程
        primaryStage.setOnCloseRequest(e -> {
            ProcessCal.sign=true;
        });
        
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, scrollpane, dscrollpane, buttonBar);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
