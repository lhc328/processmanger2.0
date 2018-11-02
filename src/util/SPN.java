/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.PCB;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import processman.GetPCB;
import processman.ProcessMan;

/**
 *
 * @author kOX
 * 最短进程优先
 */
public class SPN extends ProcessCal{
    @Override
    public void run(){
        Comparator<PCB> comparator = new Comparator<PCB>() {
            public int compare(PCB p1, PCB p2) {
                if (p1.getTime() != p2.getTime()) {
                    return p1.getTime() - p2.getTime();
                } else {
                    return p1.getName() - p2.getName();
                }
            }
        };

        Collections.sort(relist, comparator);
        while (!super.sign) {
            if(relist.isEmpty()){
                currentPcb = new PCB(0,3,0,0,0);
                GetPCB.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }else{
                currentPcb = relist.remove(0);
                currentPcb.setStatus("运行");
                GetPCB.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SPN.class.getName()).log(Level.SEVERE, null, ex);
                }
                currentPcb.setTime(0);
                currentPcb.setStatus("结束");
                maxPcb++;
            }                               //有到达新进程，就要重新排序
            Collections.sort(relist, comparator);
            ProcessMan.tv.refresh();
        }
    }
}
