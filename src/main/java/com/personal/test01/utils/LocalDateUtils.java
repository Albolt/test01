package com.personal.test01.utils;

import cn.hutool.core.date.LocalDateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateUtils {

    public static final String            YYYYMM             = "yyyyMM";
    public static final String            YYYYMMDD             = "yyyyMMdd";
    public static final String            YYYY_MM_DD           = "yyyy-MM-dd";
    public static final DateTimeFormatter YYYYMM_FORMATTER   = DateTimeFormatter.ofPattern(YYYYMM);
    public static final DateTimeFormatter YYYYMMDD_FORMATTER   = DateTimeFormatter.ofPattern(YYYYMMDD);
    public static final DateTimeFormatter YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern(YYYY_MM_DD);

    private LocalDateUtils() {
    }

    public static String formatYM(LocalDate date) {
        return format(date, YYYYMM_FORMATTER);
    }
    public static String formatYMD(LocalDate date) {
        return format(date, YYYYMMDD_FORMATTER);
    }

    public static String formatY_M_D(LocalDate date) {
        return format(date, YYYY_MM_DD_FORMATTER);
    }

    public static String format(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static LocalDate parseDate(CharSequence text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }

        if (StringUtils.length(text) > 10) {
            text = text.subSequence(0, 10);
        }

        if (StringUtils.length(text) == 8) {
            return LocalDateTimeUtil.parseDate(text, YYYYMMDD_FORMATTER);
        } else {
            return LocalDateTimeUtil.parseDate(text, YYYY_MM_DD_FORMATTER);
        }
    }

    public static String format(LocalDate date, DateTimeFormatter format) {
        return date.format(format);
    }

    /**
     * @return 明天日期
     */
    public static LocalDate getTomorrow() {
        return LocalDate.now().plusDays(1);
    }

    /**
     * @return 本月第一天
     */
    public static LocalDate firstDayOfThisMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * @return 本月最后一天
     */
    public static LocalDate lastDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * @return 本月最后一天
     */
    public static LocalDate lastDayOfMonth(LocalDate acctDate) {
        return acctDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 指定日期上月最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate lastDayOfLastMonth(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfMonth()).minusDays(1).with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 判断当前日期是否在两个日期期间内
     *
     * @param before
     * @param after
     * @return true or false
     */
    public static boolean twoDatePeriod(LocalDate before, LocalDate after) {
        LocalDate now = LocalDate.now();
        return now.isAfter(before) && now.isBefore(after);
    }

    public static boolean between(LocalDate curDate, LocalDate startDate, LocalDate endDate) {
        if (curDate == null || startDate == null || endDate == null) {
            return false;
        }
        if (curDate.isEqual(startDate) || curDate.isEqual(endDate)) {
            return true;
        }
        return curDate.isBefore(endDate) && curDate.isAfter(startDate);
    }

    public static long dayDiff(LocalDate startDate, LocalDate endDate) {
        //天差
        return endDate.toEpochDay() - startDate.toEpochDay();
    }

    public static long monthDiff(LocalDate startDate, LocalDate endDate) {
        //年差
        long years = endDate.getYear() - startDate.getYear();
        //月差
        long months = years * 12 + (endDate.getMonthValue() - startDate.getMonthValue());
        return months;
    }

    public static long yearDiff(LocalDate startDate, LocalDate endDate) {
        //年差
        return endDate.getYear() - startDate.getYear();
    }

    public static boolean isSameDay(LocalDate localDate, LocalDate nextDate) {
        if (localDate == null && nextDate == null) {
            return true;
        }
        if (localDate != null && nextDate != null) {
            return localDate.isEqual(nextDate);
        }
        return false;
    }

    /**
     * @param leftDate  可为空
     * @param rightDate 不可为空
     * @return
     */
    public static LocalDate min(LocalDate leftDate, @NonNull LocalDate rightDate) {
        leftDate = leftNull(rightDate, leftDate);
        return leftDate.isBefore(rightDate)?leftDate:rightDate;
    }

    public static LocalDate max(LocalDate leftDate, @NonNull LocalDate rightDate) {
        leftDate = leftNull(rightDate, leftDate);
        return leftDate.isAfter(rightDate)?leftDate:rightDate;
    }

    public static void main(String[] args) {
        System.out.println(maxs(null,null,LocalDate.of(2021,1,1),LocalDate.of(2021,2,1)));
    }

    public static LocalDate maxs(LocalDate... dates) {
       if(dates!=null){
           LocalDate maxDate=null;
           for (LocalDate date : dates) {
               if(date!=null){
                   if(maxDate==null ){
                       maxDate = date;
                   }else {
                       if(date.isAfter(maxDate)){
                           maxDate=date;
                       }
                   }
               }

           }
           return maxDate;
       }
       return null;
    }
    /**
     * @param leftDate  可为空
     * @param rightDate 不可为空
     * @return
     */
    public static LocalDateTime min(LocalDateTime leftDate, @NonNull LocalDateTime rightDate) {
        leftDate = leftNull(rightDate, leftDate);
        return leftDate.isBefore(rightDate)?leftDate:rightDate;
    }

    public static LocalDateTime max(LocalDateTime leftDate, @NonNull LocalDateTime rightDate) {
        leftDate = leftNull(rightDate, leftDate);
        return leftDate.isAfter(rightDate)?leftDate:rightDate;
    }

    public static LocalDate maxNull(LocalDate leftDate, LocalDate rightDate) {
        if(leftDate==null||rightDate==null){
            return null;
        }
        return leftDate.isAfter(rightDate)?leftDate:rightDate;
    }

    private static LocalDateTime leftNull(LocalDateTime rightDate, LocalDateTime leftDate) {
        if (rightDate == null) {
            throw new NullPointerException();
        }
        if (leftDate == null) {
            return rightDate;
        }
        return leftDate;
    }

    private static LocalDate leftNull(LocalDate rightDate, LocalDate leftDate) {
        if (rightDate == null) {
            throw new NullPointerException();
        }
        if (leftDate == null) {
            return rightDate;
        }
        return leftDate;
    }

}
