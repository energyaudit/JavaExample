package main.RestAssured;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static main.util.TorontoTime.getCityTime;

public class CallGetCityTime {
    public static void main(String[] args)
    {
        getCityTime("Vancouver");
        getCityTime("Toronto");
        ZoneId.SHORT_IDS.keySet().
                stream().forEach(
                zoneKey ->System.out.println(" "+ ZoneId.of( ZoneId.SHORT_IDS.get( zoneKey ) ) +": "+ LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get(zoneKey))) ) );

    }
}
