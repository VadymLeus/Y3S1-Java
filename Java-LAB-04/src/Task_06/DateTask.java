package Task_06;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class DateTask {

    public static void main(String[] args) {
        LocalDateTime labStart = LocalDateTime.of(2024, 10, 12, 9, 0, 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d 'day of the year', MMMM yyyy, HH:mm:ss");
        String formattedLabStart = labStart.format(formatter);

        System.out.println("Lab start: " + formattedLabStart);

        int year = labStart.getYear();
        boolean isLeapYear = Year.of(year).isLeap();
        System.out.println("Is the year " + year + " a leap year: " + isLeapYear);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current time: " + now.format(formatter));

        if (now.isAfter(labStart)) {
            System.out.println("Current time is after the lab start.");
        } else if (now.isBefore(labStart)) {
            System.out.println("Current time is before the lab start.");
        } else {
            System.out.println("Current time matches the lab start time.");
        }

        LocalDateTime updatedLabStart = labStart.plusDays(5).plusHours(3).minusMinutes(10);
        System.out.println("Updated lab start time: " + updatedLabStart.format(formatter));
    }
}
