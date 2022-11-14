package com.itheima;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:55
 * @Version 1.0
 */
public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task run...");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}