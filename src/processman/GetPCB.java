/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;

import bean.PCB;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import static processman.ProcessMan.table;
import util.ProcessCal;

/**
 *
 * @author kOX
 */
public class GetPCB extends Thread {
    ArrayList<PCB> data = new ArrayList<PCB>();
    @Override
    public void run() {
       
        while(!ButtonBar.sstop){
            if (ProcessCal.sign) {
                PCB entry = new PCB(ProcessCal.currentPcb);
                data.add(entry);
                
                ProcessMan.view.setItems(FXCollections.observableArrayList(data));
                ProcessMan.view.refresh();
                ProcessCal.sign = false;
                ProcessMan.tv.refresh();
            }
            try {
                Thread.sleep(100);
                //System.out.println("ButtonBar.sstop");
            } catch (InterruptedException ex) {
                Logger.getLogger(GetPCB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
