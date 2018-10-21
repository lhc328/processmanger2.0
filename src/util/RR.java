/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.PCB;

/**
 *
 * @author kOX
 */
public class RR extends ProcessCal {

    @Override
    public void run() {
        int slicetime = time;
        while (!super.sign) {
            if (super.relist.isEmpty()) {
                currentPcb = new PCB(0, 3, 0, 0, 0);
                super.sign = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } else {
                currentPcb = relist.remove(0);
                if (currentPcb.getTime() <= slicetime) {
                    currentPcb.setStatus("运行");
                    super.sign = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    currentPcb.setTime(0);
                    currentPcb.setStatus("结束");
                    maxPcb++;
                } else {
                    currentPcb.setStatus("运行");
                    super.sign = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    currentPcb.setTime(currentPcb.getTime() - slicetime);
                    currentPcb.setStatus("就绪");
                    relist.add(currentPcb);
                }
            }
        }
    }
}