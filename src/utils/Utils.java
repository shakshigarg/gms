package utils;

import java.security.Timestamp;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static long getTimeInLong(String startTime) {
        try {
            Date date = sdf1.parse(startTime);
            return date.getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
