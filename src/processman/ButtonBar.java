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
import javafx.scene.layout.HBox;
import util.ProcessCal;
import util.*;

/**
 *
 * @author kOX
 */
public class ButtonBar {

    public static ProcessCal processCal = null;
    public static boolean sstop = false;
    public static boolean runflag = false;
    public static ArrayList<PCB> data = new ArrayList<PCB>();
    public static HBox initBar() {
        HBox bar = new HBox();
        bar.setPadding(new Insets(30, 80, 30, 80));  //上左下右
        bar.setSpacing(30);   //控件间隔
        ArrayList<PCB> Pdata = new ArrayList<PCB>();

        
        Button btNew = new Button("添加数据");
        btNew.setOnAction((e) -> {
            for (int i = 0; i < 10; i++) {
                PCB pcb = new PCB();
                ProcessCal.relist.add(pcb);
                ProcessCal.savelist.add(pcb);
            }
            switch (MenuEdit.style) {
                case 1:
                    processCal = new RR();
                    break;
                case 2:
                    processCal = new PF();
                    break;
                case 3:
                    processCal = new SPN();
                    break;
                case 4:
                    processCal = new SRT();
                    break;
                default:
                    break;
            }
            Pdata.removeAll(Pdata);
            for (int i = 0; i < ProcessCal.savelist.size(); i++) {
                Pdata.add(ProcessCal.savelist.get(i));
            }
            ProcessMan.tv.setItems(FXCollections.observableArrayList(Pdata));
        });

        Button btStop = new Button("暂停");
        btStop.setOnAction((e) -> {
//            sstop = true;
            ProcessCal.sign = true;
            runflag=false;
        });

        Button btRun = new Button("开始运行");
        btRun.setOnAction((e) -> {
            if (ProcessCal.relist.isEmpty()) {
                System.out.println("请先添加数据");
            }else if(runflag){
                System.out.println("已经运行了");
            } else {
                runflag=true;
//                sstop=false;
                ProcessCal.sign = false;
                Thread thread = new Thread(processCal);
                thread.start();
//                GetPCB getpcb = new GetPCB();
//                getpcb.start();
            }
        });

        Button btClear = new Button("清空数据");

        bar.getChildren().addAll(btNew, btStop, btRun, btClear);
        return bar;
    }
}
