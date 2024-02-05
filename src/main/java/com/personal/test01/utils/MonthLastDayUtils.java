package com.personal.test01.utils;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.lang.func.Func0;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class MonthLastDayUtils {
    /**
     * 2023年1月从原来的每月倒数第二天改为倒数第四天
     */
    private static final int                                                   days                       = 4;
    /**
     * 2023年1月从原来的每月倒数第二天改为倒数第四天，因为上一月月末用的是2022-12-29 这里结束需要用2022-12-30
     */
    private static final LocalDate                                             MONTH_REPORT_MIN_START_DAY = LocalDate.of(2022, 12, 30);
    private static final int                                                   CACHE_TIME                 = 5 * 60;
    private static final TimedCache<LocalDate, Boolean>                        lastReportTimedCache       = CacheUtil.newTimedCache(
            CACHE_TIME);
    public static final  TimedCache<LocalDate, TimedCache<LocalDate, Boolean>> inMonthReportTimeCache
                                                                                                          = CacheUtil.newTimedCache(CACHE_TIME);
    private static final TimedCache<LocalDate, LocalDate>                      endDateTimedCache          = CacheUtil.newTimedCache(
            CACHE_TIME);
    public static final  TimedCache<LocalDate, String>                         reportMonthTimeCache       = CacheUtil.newTimedCache(CACHE_TIME);

    /**
     * 缓存加速判断是否没有倒数第二天上报，适用于EAST 资金报备
     *
     * @param acctDate
     * @return
     */
    public static boolean isLastReportDay(LocalDate acctDate) {
        return lastReportTimedCache.get(acctDate, true, () -> {
            LocalDate endDay = acctDate.with(TemporalAdjusters.lastDayOfMonth()).minusDays(days);
            return endDay.isEqual(acctDate);
        });
    }

    public static void main(String[] args) {

        System.out.println(inMonth(LocalDate.of(2023, 05, 26), LocalDate.of(2023, 06, 12)));
        System.out.println(inMonth(LocalDate.of(2023, 05, 27), LocalDate.of(2023, 06, 12)));
        System.out.println(inMonth(LocalDate.of(2023, 05, 28), LocalDate.of(2023, 06, 12)));



        System.out.println(inMonth(LocalDate.of(2023, 05, 26), LocalDate.of(2023, 05, 29)));
        System.out.println(inMonth(LocalDate.of(2023, 05, 27), LocalDate.of(2023, 05, 29)));
        System.out.println(inMonth(LocalDate.of(2023, 05, 28), LocalDate.of(2023, 05, 29)));
    }

    /**
     * 每月最后一天
     *
     * @param acctDate
     * @return
     */
    public static boolean isLastDay(LocalDate acctDate) {
        LocalDate endDay = acctDate.with(TemporalAdjusters.lastDayOfMonth());
        return endDay.isEqual(acctDate);
    }

    /**
     * 缓存加速判断是否没有倒数第二天上报，适用于EAST 资金报备
     *
     * @param gDate
     * @param acctDate
     * @return
     */
    public static boolean inMonthReport(LocalDate gDate, LocalDate acctDate) {
        TimedCache<LocalDate, Boolean> timedCache = inMonthReportTimeCache.get(acctDate, true,
                () -> CacheUtil.newTimedCache(CACHE_TIME));
        return timedCache.get(gDate, true, () -> {
            boolean lastReportDay = isLastReportDay(acctDate);
            if (lastReportDay) {
                LocalDate endDay   = monthReportEndDate(acctDate);
                LocalDate startDay = monthReportStartDate(acctDate);
                return LocalDateUtils.between(gDate, startDay, endDay);
            }
            return false;
        });
    }

    /**
     *
     *
     * @param gDate
     * @param acctDate
     * @return
     */
    public static boolean inMonth(LocalDate gDate, LocalDate acctDate) {
        LocalDate endDay   = monthReportEndDate(acctDate);
        LocalDate startDay = monthReportStartDate(acctDate);
        return LocalDateUtils.between(gDate, startDay, endDay);
    }

    public static String reportMonthStr(LocalDate acctDate) {
        return reportMonthTimeCache.get(acctDate, true,
                new Func0() {
                    @Override
                    public Object call() throws Exception {
                        synchronized (this) {
                            return LocalDateUtils.formatYM(monthReportEndDate(acctDate));
                        }
                    }
                }
        );
    }


    public static LocalDate monthReportStartDate(LocalDate acctDate) {
        //当月报送日期
        LocalDate curMonthReportDate = acctDate.with(TemporalAdjusters.lastDayOfMonth()).minusDays(days);
        //日期在当月报送日期之后
        if (acctDate.isAfter(curMonthReportDate)) {
            //报送日期加1天
            return curMonthReportDate.plusDays(1);
        } else {
            LocalDate startDate = acctDate.with(TemporalAdjusters.firstDayOfMonth()).minusDays(days);
            if (MONTH_REPORT_MIN_START_DAY.isAfter(startDate)) {
                return MONTH_REPORT_MIN_START_DAY;
            } else {
                return startDate;
            }
        }
    }

    public static LocalDate monthReportEndDate(LocalDate acctDate) {
        //当月报送日期
        LocalDate curMonthReportDate = acctDate.with(TemporalAdjusters.lastDayOfMonth()).minusDays(days);
        if (acctDate.isAfter(curMonthReportDate)) {
            return curMonthReportDate.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).minusDays(days);
        } else {
            return curMonthReportDate;
        }
    }

    /**
     * 合同结束日期若是月末两天，将结束日期修改为下月首日
     *
     * @param endDate
     * @return
     */
    public static LocalDate transEndDate(LocalDate endDate) {
        return endDateTimedCache.get(endDate, true, () -> {
            LocalDate lastDay  = endDate.with(TemporalAdjusters.lastDayOfMonth());
            LocalDate startDay = lastDay.minusDays(3);
            if (LocalDateUtils.between(endDate, startDay, lastDay)) {
                return lastDay.plusDays(1);
            } else {
                return endDate;
            }
        });
    }
}
