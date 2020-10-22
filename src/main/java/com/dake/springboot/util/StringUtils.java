package com.dake.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class StringUtils {

    public static final String TIME_FORMATTER_PATTERN_YMDHMS = "yyyyMMddHHmmss";

    public static String gerenateRandomId(String prefix, int length){

        StringBuilder sb = new StringBuilder(prefix);
        sb.append(getSysTimeStr(TIME_FORMATTER_PATTERN_YMDHMS));

        int nonRandomLength = prefix.length() + TIME_FORMATTER_PATTERN_YMDHMS.length();

        if (length <= nonRandomLength) {
            throw new RuntimeException(String.format("流水号长度必须大于%s位", nonRandomLength));
        }

        Random random = new Random();
        int nextInt;
        for (int i = 0, len = length - nonRandomLength; i < len; i++) {
            nextInt = random.nextInt(10);
            sb.append(nextInt);
        }

        return sb.toString();
    }

    public static String getSysTimeStr(String pattern) {
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(TIME_FORMATTER_PATTERN_YMDHMS).format(now);
    }

    public static void main(String[] args) {
        System.out.println(gerenateRandomId("ABNML", 26));
    }
}
