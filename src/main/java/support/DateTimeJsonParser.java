package support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeJsonParser {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

    public String parseDateToString(Date date){
        return dateFormat.format(date);
    }

    public Date parseStringToDate(String stringDate){
        try {
            return dateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
