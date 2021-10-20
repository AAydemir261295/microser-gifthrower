package qk.myGroup.gifThrower.ClientsImpl;

import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Service {

    @Value("${richTag}")
    String richTag;
    @Value("${brokeTag}")
    String brokeTag;


    public String getYesterdayDay(int mils){
        long yesterdayInMilisec = (1634626800 * 1000L) - 86400000;
        Instant instant = Instant.ofEpochMilli(yesterdayInMilisec);
        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );

        return zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDiff(Double last, Double previous) {
        String result = "";

        if(last > previous){
            return result = richTag;
        }
        else {
            return result = brokeTag;
        }
    }
}
