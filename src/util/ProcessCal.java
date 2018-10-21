/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.PCB;
import java.util.ArrayList;

/**
 *
 * @author kOX
 */
public class ProcessCal implements Runnable{
    public static boolean sign = false;
    public static int maxPcb = 10;
    public int time =1;
    public static int minx = 0;
    public static ArrayList<Integer> timelist = new ArrayList();
    public static ArrayList<PCB> relist = new ArrayList();      //就绪队列
    public static ArrayList<PCB> savelist = new ArrayList();    //进程保存队列
    public static ArrayList<PCB> waitlist = new ArrayList();    //到达队列
    public static PCB currentPcb = new PCB(0,3,0,0,0);  
   
    @Override
    public void run(){}
}
