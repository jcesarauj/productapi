package com.productapi.utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public String formateDateTimeLocalStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
