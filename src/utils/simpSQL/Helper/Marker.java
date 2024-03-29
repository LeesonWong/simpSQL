package utils.simpSQL.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author LeesonWong
 * @date 2019/11/17 17:18
 */
public class Marker {

    private Marker() {
    }

    static Date date = null;
    static SimpleDateFormat dateFormat = null;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        TimeZone.setDefault(timeZone);
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    public static String getTimer(){
        return dateFormat.format(date) + "\t";
    }
}
