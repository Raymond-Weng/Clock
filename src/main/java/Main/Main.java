package Main;

import Frm.Alarm;
import Frm.TimeFrm;
import Loop.Loop;

import javax.swing.*;
import java.io.File;

public class Main {
    private static Main main = null;

    private int hour;
    private int min;
    private int sec;
    private Loop loop;
    private boolean isAlarmOn = false;
    private String alarmTime;

    private Main(){
        hour = 0;
        min = 0;
        sec = 0;
    }

    public static Main get(){
        if(main == null){
            main = new Main();
        }
        return main;
    }

    public static void main(String[] args) {
        Main main = Main.get();
        main.checkFile();
        main.run();
    }

    private void run() {
        TimeFrm.get();

        loop = Loop.get();
        loop.start();
    }

    public void update() {
        this.setSec(sec + 1);
        if(isAlarmOn){
            if((this.getHour() + ":" + this.getMin() + ":" + this.getSec()).equals(alarmTime)){
                Thread thread = new Thread(new Alarm());
                thread.start();
            }
        }
        TimeFrm.get().update();
    }

    public String getHour() {
        if(hour < 10){
            return 0 + String.valueOf(hour);
        }else {
            return (String.valueOf(hour));
        }
    }

    public String getMin() {
        if(min < 10){
            return 0 + String.valueOf(min);
        }else {
            return (String.valueOf(min));
        }
    }

    public String getSec() {
        if(sec < 10){
            return 0 + String.valueOf(sec);
        }else {
            return (String.valueOf(sec));
        }
    }

    public void setHour(int hour) {
        this.hour = hour;
        if(hour < 0){
            this.setHour(24 + hour);
        }
        if(hour >= 24){
            this.setHour(hour - 24);
        }
        TimeFrm.get().update();
    }

    public void setMin(int min) {
        this.min = min;
        if(min < 0){
            this.setMin(60 + min);
            this.setHour(hour - 1);
        }
        if(min >= 60){
            this.setMin(min - 60);
            this.setHour(hour + 1);
        }
        TimeFrm.get().update();
    }

    public void setSec(int sec) {
        this.sec = sec;
        if(sec < 0){
            this.setSec(60 + sec);
            this.setMin(min - 1);
        }
        if(sec >= 60){
            this.setSec(sec - 60);
            this.setMin(min + 1);
        }
        TimeFrm.get().update();
    }

    public void checkFile(){
        boolean isAllFileExist = true;
        for(int i = 0 ; i <= 9 ; i++){
            if(!(new File("./numbers/" + String.valueOf(i) + ".png").exists())){
                isAllFileExist = false;
            }
        }
        if(!(new File("./numbers/" + "colon" + ".png").exists())){
            isAllFileExist = false;
        }
        if(!(isAllFileExist)){
            JOptionPane.showMessageDialog(null,"There are some files missing.","File missing",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public void setAlarmOn(boolean alarmOn) {
        isAlarmOn = alarmOn;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }
}
