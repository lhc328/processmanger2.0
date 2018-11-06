/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.PCB;
import processman.GetPCB;
import processman.ProcessMan;

/**
 *
 * @author kOX
 * 时间片轮转
 */
public class RR extends ProcessCal {

    @Override
    public void run() {
        int slicetime = 1;
        while (!super.sign) {
            if (super.relist.isEmpty()) {
                currentPcb = new PCB(0, 3, 0, 0, 0);
                GetPCB.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } else {
                currentPcb = relist.remove(0);
                currentPcb.setStatus("运行");
                GetPCB.run();
                if (currentPcb.getTime() <= slicetime) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    currentPcb.setTime(0);
                    currentPcb.setStatus("结束");
                    maxPcb++;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    currentPcb.setTime(currentPcb.getTime() - slicetime);
                    currentPcb.setStatus("就绪");
                    relist.add(currentPcb);
                }
                time++;
            }
            ProcessMan.tv.refresh();
        }
    }
}
