package de.threads;

import java.util.ArrayList;

public class TestOverrideThread implements Runnable {

    public static void alertAdministrator(Throwable e) {
        // Use Java Mail to send the administrator's pager an email
        System.out.println("Adminstrator alert!");
        e.printStackTrace();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new TestOverrideThread());
        t.setUncaughtExceptionHandler(new OverrideExceptionHandler());
        System.out.println(t.getUncaughtExceptionHandler());
        t.start();
    }

    public void run() {
        ArrayList al = new ArrayList();
        while (true) {
            al.add(new byte[1024]);
        }
    }

    static class OverrideExceptionHandler implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread t, Throwable e) {
            alertAdministrator(e);
        }
    }
}
