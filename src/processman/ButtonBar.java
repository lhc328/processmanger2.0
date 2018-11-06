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
import util.RR;

/**
 *
 * @author kOX
 */
public class ButtonBar {

    public static ProcessCal processCal = new RR();

    public static boolean runflag = false;
    public static ArrayList<PCB> data = new ArrayList<PCB>();

    public static HBox initBar() {
        HBox bar = new HBox();
        bar.setPadding(new Insets(30, 30, 30, 30));  //上左下右
        bar.setSpacing(30);   //控件间隔
        TextField addCount = new TextField();       //输入线程数
        addCount.setMaxWidth(80);
        addCount.setPromptText("新建线程数");

        Button btNew = new Button("添加数据");
        btNew.setOnAction((e) -> {
            if (runflag) {
                ErrorWin.errorShow("请先暂停再添加数据");
            } else if (addCount.getText().equals("")) {
                ErrorWin.errorShow("请添加数据");
            } else {
                int a = Integer.parseInt(addCount.getText());
                if (a > ProcessCal.maxPcb) {
                    ErrorWin.errorShow("线程数不足，当前还有" + ProcessCal.maxPcb + "个空位");
                } else {
                    ProcessCal.maxPcb -= a;
                    for (int i = 0; i < a; i++) {
                        PCB pcb = new PCB();
                        ProcessCal.relist.add(pcb);
                        ProcessCal.savelist.add(pcb);
                    }
                    ProcessMan.tv.setItems(FXCollections.observableArrayList(ProcessCal.savelist));
                }
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
                ErrorWin.errorShow("请先添加数据");
            } else if (runflag) {
                ErrorWin.errorShow("已经运行了");
            } else {
                runflag = true;
                ProcessCal.sign = false;
                Thread thread = new Thread(processCal);
                thread.start();
            }
        });

        Button btClear = new Button("清空数据");
        btClear.setOnAction((e) -> {
            if (runflag) {
                ErrorWin.errorShow("请先暂停再清除数据");
            } else {
                ProcessCal.sign = true;
                ProcessCal.relist.removeAll(ProcessCal.relist);
                ProcessCal.maxPcb = 10;
                ProcessCal.savelist.removeAll(ProcessCal.savelist);
                runflag = false;
                ProcessCal.time = 0;
                data.removeAll(data);
                ProcessCal.minx = 0;
                ProcessMan.tv.setItems(FXCollections.observableArrayList(ProcessCal.savelist));
                ProcessMan.view.setItems(FXCollections.observableArrayList(data));
                ProcessCal.reflag = true;
            }
        });
        bar.getChildren().addAll(addCount, btNew, btStop, btRun, btClear);
        return bar;
    }
}
