package ranttu.rapid.jsvmdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

// the logger
public class Logger {
    public void info3(Object i1, Object i2, Object i3) {
        synchronized (System.out) {
            System.out.println(formatString("INFO", i1, i2, i3));
        }
    }


    public void info6(Object i1, Object i2, Object i3, Object i4, Object i5, Object i6) {
        synchronized (System.out) {
            System.out.println(formatString("INFO", i1, i2, i3, i4, i5, i6));
        }
    }

    public void info(Object...infos) {
        synchronized (System.out) {
            System.out.println(formatString("INFO", infos));
        }
    }

    public void err(Object...infos) {
        synchronized (System.err) {
            System.err.println(formatString("ERROR", infos));
        }
    }

    private String formatString(String lv, Object...infos) {
        Date now = new Date();
        StringBuilder info = new StringBuilder();
        for(Object i: infos) {
            info.append(i).append(" ");
        }

        return String.format("[%s] %s: %s",
            lv, new SimpleDateFormat("dd hh:mm:ss.SSS").format(now), info.toString());
    }
}
