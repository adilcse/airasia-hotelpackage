package com.airasia.hotelpackagemanager.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contain utility methods to format date
 * @author nitish
 */
public class DateFormatUtil {

    public static Date parseDateYYYYMMDD(String date) throws Exception {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(date);
        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String fomratDateYYYYMMDD(Date date) throws Exception {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }
}
