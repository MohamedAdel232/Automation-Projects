package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ssa").format(new Date());
    }
}
