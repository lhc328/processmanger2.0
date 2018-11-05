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
        PCB entry = new PCB(ProcessCal.currentPcb);
        ButtonBar.data.add(entry);
        ProcessMan.view.setItems(FXCollections.observableArrayList(ButtonBar.data));
        ProcessMan.view.refresh();
        ProcessMan.tv.refresh();
    }
}
