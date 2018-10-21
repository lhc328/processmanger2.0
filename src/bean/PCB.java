/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import util.ProcessCal;

/**
 *
 * @author kOX
 */
public class PCB {
     private int name;
    private String status;
    private int priority;
    private int time;
    private int starttime;
    
    public PCB(){
        this.name = ++ProcessCal.minx;
        this.status = "就绪";
        this.priority = (int)(Math.random()*3);
        this.time = (int)(Math.random()*9+1);
        this.starttime = 0; //(int)(Math.random()*9);
    }
    
    public PCB(int name, int status, int priority, int time, int starttime){
        this.name = name;
        if(status==0){
        this.status = "就绪";
        }else if(status==1){
            this.status="运行";
        }else if(status==2){
            this.status="结束";
        }else{
            this.status="空闲";
        }
        this.priority = priority;
        this.time = time;
        this.starttime = starttime;
    }
    
    public PCB(PCB i){
        this.name = i.name;
        this.status = i.status;
        this.priority = i.priority;
        this.time = i.time;
        this.starttime = i.starttime;
    }
    /**
     * @return the name
     */
    public int getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the starttime
     */
    public int getStarttime() {
        return starttime;
    }

    /**
     * @param starttime the starttime to set
     */
    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }
}
