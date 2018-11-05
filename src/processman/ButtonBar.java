/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;

import bean.PCB;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import util.ProcessCal;

/**
 *
 * @author kOX
 */
public class ButtonBar {

    public static ProcessCal processCal = null;

    public static boolean runflag = false;
    public static ArrayList<PCB> data = new ArrayList<PCB>();

    public static HBox initBar() {
        HBox bar = new HBox();
        bar.setPadding(new Insets(30, 30, 30, 30));  //上左下右
        bar.setSpacing(30);   //控件间隔
        ArrayList<PCB> Pdata = new ArrayList<PCB>();
        TextField addCount = new TextField();       //输入线程数
        addCount.setMaxWidth(80);
        addCount.setPromptText("新建线程数");

        Button btNew = new Button("添加数据");
        btNew.setOnAction((e) -> {
            int a = Integer.parseInt(addCount.getText());
            if (a > ProcessCal.maxPcb) {
                System.out.println("线程数不足");
            } else {
                for (int i = 0; i < a; i++) {
                    PCB pcb = new PCB();
                    ProcessCal.relist.add(pcb);
                    ProcessCal.savelist.add(pcb);
                }
                Pdata.removeAll(Pdata);
                for (int i = 0; i < ProcessCal.savelist.size(); i++) {
                    Pdata.add(ProcessCal.savelist.get(i));
                }
                ProcessMan.tv.setItems(FXCollections.observableArrayList(Pdata));
            }
        });

        Button btStop = new Button("暂停");
        btStop.setOnAction((e) -> {
            ProcessCal.sign = true;
            runflag = false;
        });

        Button btRun = new Button("开始运行");
        btRun.setOnAction((e) -> {
            if (ProcessCal.relist.isEmpty()) {
                System.out.println("请先添加数据");
            } else if (runflag) {
                System.out.println("已经运行了");
            } else {
                runflag = true;
                ProcessCal.sign = false;
                Thread thread = new Thread(processCal);
                thread.start();
            }
        });

        Button btClear = new Button("清空数据");

        bar.getChildren().addAll(addCount, btNew, btStop, btRun, btClear);
        return bar;
    }
}
