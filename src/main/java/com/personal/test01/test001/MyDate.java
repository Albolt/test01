package com.personal.test01.test001;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Creater albolt
 * @12/12/20 7:39 PM
 */

public class MyDate implements Comparable<MyDate> {

    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate() {
        this.year = 1980;
        this.month = 1;
        this.day = 1;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setDate(String date) {
        String[] dates = date.split("/");
        if (dates.length!=3) {
            throw new InvalidDateException("illegal String argument ("+ date +")");
        }
        String yearS = dates[0];
        String monthS = dates[1];
        String dayS = dates[2];
        if (!yearS.matches("^\\d{4}$")) {
            throw new InvalidDateException("illegal String argument ("+ date +")");
        } else if (!monthS.matches("^\\d*$")) {
            throw new InvalidDateException("illegal String argument ("+ date +")");
        } else if (!dayS.matches("^\\d*$")) {
            throw new InvalidDateException("illegal String argument ("+ date +")");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM");
        Date dateD = new Date();
        try {
            String newdate = dates[0]+"/"+dates[1];
            dateD = formatter.parse(newdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateD);
        int dayMax = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Integer yearI = Integer.parseInt(yearS);
        Integer monthI = Integer.parseInt(monthS);
        Integer dayI = Integer.parseInt(dayS);
        if (monthI<1 || monthI > 12) {
            throw new InvalidDateException("illegal month ("+ monthS +")");
        }
        if (dayI<1 || dayI > dayMax) {
            throw new InvalidDateException("illegal day (" + dayS + ")");
        }
        this.year = yearI;
        this.month = monthI;
        this.day = dayI;

    }

    @Override
    public String toString() {
        return String.format("%04d", this.year) + "/" +
               String.format("%02d", this.month) + "/" +
               String.format("%02d", this.day);
    }

    public boolean equals(MyDate myDate) {
        if (myDate.getDay().equals(this.day) && myDate.getMonth().equals(this.month) && myDate.getYear().equals(this.year)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(MyDate myDate) {
        if (myDate.getYear()>this.getYear()) {
            return 1;
        } else if (myDate.getYear()<this.year) {
            return -1;
        } else {
            if (myDate.getMonth()>this.month) {
                return 1;
            } else if (myDate.getMonth()<this.month) {
                return -1;
            } else {
                if (myDate.getDay()>this.day) {
                    return 1;
                } else if (myDate.getDay()<this.day) {
                    return -1;
                }
            }
        }
        return 0;
    }

}
