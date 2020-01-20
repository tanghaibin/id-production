package com.hobson.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haibin.tang
 * @date 2020-01-20 14:22:33
 * 压缩日期长度
 */
public class CompressDateUtil {
    /**
     * 年 对应编码
     */
    private static Map<Integer, String> yearEncode;
    /**
     * 月 对应编码
     */
    private static Map<Integer, String> monthEncode;
    /**
     * 日 对应编码
     */
    private static Map<Integer, String> dayEncode;
    /**
     * 时 对应编码
     */
    private static Map<Integer, String>  hourEncode;
    /**
     * 分 秒 对应编码
     */
    private static Map<Integer, String>  minuteEncode;
    /**
     * 起始年份
     */
    private static final Integer START_YEAR = 2020;

    private static final String [] YEAR_ENCODE_CODE = new String[]{
            "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    private static final String[] MONTH_ENCODE_CODE = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "H", "I"
    };

    private static final String [] DAY_ENCODE_CODE = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5"
    };

    private static final String [] HOUR_ENCODE_CODE = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X"
    };

    private static final String [] MINUTE_ENCODE_CODE = new String[]{
            "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "I1", "J1", "K1", "L1", "M1", "N1", "O1", "P1", "Q1", "R1", "S1", "T1", "U1", "V1", "W1", "X1", "Y1", "Z1",
            "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "I2", "J2", "K2", "L2", "M2", "N2", "O2", "P2", "Q2", "R2", "S2", "T2", "U2", "V2", "W2", "X2", "Y2", "Z2",
            "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3"
    };

    static {
        initYearEncode();
        initMonthEncode();
        initDayEncode();
        initHourEncode();
        initMinuteEncode();
    }

    private static void initYearEncode() {
        yearEncode = new HashMap<>(25);
        int currentYear = START_YEAR;
        for (int index = 1; index <= YEAR_ENCODE_CODE.length; ++index) {
            yearEncode.put(currentYear++, YEAR_ENCODE_CODE[index - 1]);
        }
    }

    private static void initMonthEncode() {
        monthEncode = new HashMap<>(12);
        for (int index = 1; index <= MONTH_ENCODE_CODE.length; ++index) {
            monthEncode.put(index, MONTH_ENCODE_CODE[index - 1]);
        }
    }

    private static void initDayEncode() {
        dayEncode = new HashMap<>(31);
        for (int index = 1; index <= DAY_ENCODE_CODE.length; ++index) {
            dayEncode.put(index, DAY_ENCODE_CODE[index - 1]);
        }
    }

    private static void initHourEncode() {
        hourEncode = new HashMap<>(24);
        for (int index = 0; index < HOUR_ENCODE_CODE.length; ++index) {
            hourEncode.put(index, HOUR_ENCODE_CODE[index]);
        }
    }

    private static void initMinuteEncode() {
        minuteEncode = new HashMap<>(60);
        for (int index = 0; index < MINUTE_ENCODE_CODE.length; ++index) {
            minuteEncode.put(index, MINUTE_ENCODE_CODE[index]);
        }
    }

    /**
     * 对日期进行编码
     *  日期必须精确到  毫秒
     * @param date
     * @return
     */
    public static String encode(LocalDateTime date) {
        if(date == null) {
            return null;
        }
        return yearEncode.get(date.getYear()) +
                monthEncode.get(date.getMonthValue()) +
                dayEncode.get(date.getDayOfMonth()) +
                hourEncode.get(date.getHour()) +
                minuteEncode.get(date.getMinute()) +
                minuteEncode.get(date.getSecond()) +
                date.get(ChronoField.MILLI_OF_SECOND);
    }
}
