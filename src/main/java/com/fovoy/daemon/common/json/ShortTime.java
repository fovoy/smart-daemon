package com.fovoy.daemon.common.json;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zxz.zhang on 15/11/14.
 */
public class ShortTime implements Serializable, Comparable<ShortTime> {
    private static final long serialVersionUID = -4554798261160788012L;
    protected int bits;

    /** @deprecated */
    @Deprecated
    public ShortTime() {
    }

    public ShortTime(String time) {
        String[] p = time.split(":");
        boolean h = false;
        boolean m = false;
        boolean s = false;
        if(p.length != 3) {
            throw new IllegalArgumentException("time string pattern should be hh:mm:ss");
        } else {
            int h1 = Integer.parseInt(p[0]);
            int m1 = Integer.parseInt(p[1]);
            int s1 = Integer.parseInt(p[2]);
            this.init(h1, m1, s1);
        }
    }

    public ShortTime(String time, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date parsedDate = df.parse(time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(parsedDate);
        this.init(cal.get(11), cal.get(12), cal.get(13));
    }

    public ShortTime(int hours, int minutes, int seconds) {
        this.init(hours, minutes, seconds);
    }

    private void init(int hours, int minutes, int seconds) {
        check(hours, 0, 47, "hours is invalid");
        check(minutes, 0, 59, "minutes is invalid");
        check(seconds, 0, 59, "seconds is invalid");
        this.bits = 0;
        this.bits |= hours;
        this.bits <<= 6;
        this.bits |= minutes;
        this.bits <<= 6;
        this.bits |= seconds;
    }

    public int getHour() {
        return this.bits >> 12 & 63;
    }

    public int getMinute() {
        return this.bits >> 6 & 63;
    }

    public int getSecond() {
        return this.bits >> 0 & 63;
    }

    public void setHour(int hour) {
        check(hour, 0, 47, "hour is invalid");
        this.bits |= hour << 12;
    }

    public void setMinute(int minute) {
        check(minute, 0, 59, "minute is invalid");
        this.bits |= minute << 6;
    }

    public void setSecond(int second) {
        check(second, 0, 59, "second is invalid");
        this.bits |= second;
    }

    public int hashCode() {
        return this.bits;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            ShortTime other = (ShortTime)obj;
            return this.bits == other.bits;
        }
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(this.getHour()), Integer.valueOf(this.getMinute()), Integer.valueOf(this.getSecond())});
    }

    public int compareTo(ShortTime o) {
        long c = (long)(this.toSeconds() - o.toSeconds());
        return c == 0L?0:(c < 0L?-1:1);
    }

    public boolean after(ShortTime o) {
        return this.toSeconds() > o.toSeconds();
    }

    public boolean before(ShortTime o) {
        return this.toSeconds() < o.toSeconds();
    }

    public static ShortTime valueOf(String value) {
        return new ShortTime(value);
    }

    public static ShortTime valueOf(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return new ShortTime(cal.get(11), cal.get(12), cal.get(13));
    }

    public static ShortTime valueOfSeconds(int seconds) {
        int h = seconds / 3600;
        seconds -= h * 3600;
        int m = seconds / 60;
        seconds -= m * 60;
        return new ShortTime(h, m, seconds);
    }

    private static void check(int value, int min, int max, String msg) {
        if(value < min || value > max) {
            throw new IllegalArgumentException(String.format("%s: value=%d min=%d max=%d", new Object[]{msg, Integer.valueOf(value), Integer.valueOf(min), Integer.valueOf(max)}));
        }
    }

    public int toSeconds() {
        int s = this.bits >> 0 & 63;
        int m = this.bits >> 6 & 63;
        int h = this.bits >> 12 & 63;
        return h * 3600 + m * 60 + s;
    }

    public int toLiteral() {
        int s = this.bits >> 0 & 63;
        int m = this.bits >> 6 & 63;
        int h = this.bits >> 12 & 63;
        return h * 1000 + m * 100 + s;
    }
}
