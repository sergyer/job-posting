package utils;

import com.project.dto.UserDTO;
import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

/**
 * Created by sergeyy on 12/27/16.
 */
public class CommonUtils {



    public static void prepareLastVisitDate(UserDTO user) {
        /*Instant instant = user.getLastVisitedDate().toInstant();
        ZonedDateTime zd = instant.atZone(ZoneId.systemDefault());

        LocalDate lastVisited = zd.toLocalDate();
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());

        Period period = Period.between(lastVisited, currentDate);

        String result = period.getDays() + "ago";

        if (period.getMonths() != 0 || period.getYears() != 0) {
            result = period.getDays() + "days " + period.getMonths() + "months " +
                    period.getYears() + "years ago";
        }
        user.setLastVisit(result);*/

        Date date= user.getLastVisitedDate();
        PrettyTime p = new PrettyTime();
        String lastVisit = p.format(date);

        user.setLastVisit(lastVisit);

    }
}
