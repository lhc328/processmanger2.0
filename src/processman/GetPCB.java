/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;

import bean.PCB;
import javafx.collections.FXCollections;
import util.ProcessCal;

/**
 *
 * @author kOX
 */
public class GetPCB {
    
    public static void run() {
       
//        while(!ButtonBar.sstop){
//            if (ProcessCal.sign) {
                PCB entry = new PCB(ProcessCal.currentPcb);
                ButtonBar.data.add(entry);  
                ProcessMan.view.setItems(FXCollections.observableArrayList(ButtonBar.data));
                ProcessMan.view.refresh();
//                ProcessCal.sign = false;
                ProcessMan.tv.refresh();
//            }
//            try {
//                Thread.sleep(100);
//                //System.out.println("ButtonBar.sstop");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GetPCB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
}
