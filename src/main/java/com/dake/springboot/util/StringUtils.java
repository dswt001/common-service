package com.dake.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class StringUtils {

    public static final String TIME_FORMATTER_PATTERN_YMDHMS = "yyyyMMddHHmmss";

    public String gerenateRandomId(String profix, int length){
        LocalDateTime now = LocalDateTime.now();
        String nowStr = DateTimeFormatter.ofPattern(TIME_FORMATTER_PATTERN_YMDHMS).format(now);
        StringBuilder sb = new StringBuilder(profix);
        sb.append(nowStr);

        Random random = new Random();
        int nextInt;
        for (int i = 0; i < length; i++) {
            nextInt = random.nextInt(10);
            sb.append(nextInt);
        }

        return sb.toString();
    }

}
