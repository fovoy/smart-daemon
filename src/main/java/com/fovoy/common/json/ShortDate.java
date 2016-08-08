package com.fovoy.common.json;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zxz.zhang on 15/11/14.
 */
public class ShortDate implements Serializable, Comparable<ShortDate> {
    private static final long serialVersionUID = 4740133722012154374L;
    public static final ShortDate MIN_DATE = valueOf("0001-01-01");
    public static final ShortDate MAX_DATE = valueOf("9999-12-31");
    private int bits;

    /**
     * @deprecated
     */
    @Deprecated
    public ShortDate() {
    }

    public ShortDate(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null string");
        } else if (str.length() != 10) {
            throw new IllegalArgumentException("QunarDate format must be yyyy-MM-dd: " + str);
        } else {
            int year = Integer.parseInt(str.substring(0, 4));
            int month = Integer.parseInt(str.substring(5, 7));
            int day = Integer.parseInt(str.substring(8, 10));
            this.init(year, month, day);
        }
    }

    /**
     * @deprecated
     */
    @Deprecated
    public ShortDate(String date, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        df.setLenient(false);
        Date parsedDate = df.parse(date);
        int year = parsedDate.getYear() + 1900;
        int month = parsedDate.getMonth() + 1;
        int day = parsedDate.getDate();
        this.init(year, month, day);
    }

    public ShortDate(Date date) {
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int day = date.getDate();
        this.init(year, month, day);
    }

    public ShortDate(int year, int month, int day) {
        this.init(year, month, day);
    }

    private void init(int year, int month, int day) {
        check(year, 0, 9999, "year is invalid");
        check(month, 1, 12, "month is invalid");
        check(day, 1, 31, "day is invalid");
        this.bits = year;
        this.bits <<= 6;
        this.bits |= month;
        this.bits <<= 6;
        this.bits |= day;
    }

    public int getYear() {
        return this.bits >> 12 & 16383;
    }

    public int getMonth() {
        return this.bits >> 6 & 63;
    }

    public int getDay() {
        return this.bits & 63;
    }

    public void setYear(int year) {
        check(year, 0, 9999, "year is invalid");
        this.bits |= year << 12;
    }

    public void setMonth(int month) {
        check(month, 1, 12, "month is invalid");
        this.bits |= month << 6;
    }

    public void setDay(int day) {
        check(day, 1, 31, "day is invalid");
        this.bits |= day;
    }

    public Date toDate() {
        return new Date(this.getYear() - 1900, this.getMonth() - 1, this.getDay());
    }

    public int hashCode() {
        return this.bits;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            ShortDate other = (ShortDate) obj;
            return this.bits == other.bits;
        }
    }

    public String toString() {
        String yearStr = "";
        int year = this.getYear();
        if (year < 10) {
            yearStr = "000" + year;
        } else if (year < 100) {
            yearStr = "00" + year;
        } else if (year < 1000) {
            yearStr = "0" + year;
        } else {
            yearStr = String.valueOf(year);
        }

        return yearStr + "-" + fill(this.getMonth()) + "-" + fill(this.getDay());
    }

    private static String fill(int i) {
        return i < 10 ? "0" + i : Integer.toString(i, 10);
    }

    public boolean after(ShortDate o) {
        return this.toLiteral() > o.toLiteral();
    }

    public boolean before(ShortDate o) {
        return this.toLiteral() < o.toLiteral();
    }

    public int compareTo(ShortDate o) {
        int thisVal = this.toLiteral();
        int anotherVal = o.toLiteral();
        return thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1);
    }

    public static ShortDate valueOf(String value) {
        return new ShortDate(value);
    }

    public static ShortDate valueOf(Date date) {
        return new ShortDate(date);
    }

    private int toLiteral() {
        return this.getYear() * 10000 + this.getMonth() * 100 + this.getDay();
    }

    private static void check(int value, int min, int max, String msg) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format("%s: value=%d min=%d max=%d", new Object[]{msg, Integer.valueOf(value), Integer.valueOf(min), Integer.valueOf(max)}));
        }
    }
}