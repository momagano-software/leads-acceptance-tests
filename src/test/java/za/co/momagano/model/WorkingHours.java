package za.co.momagano.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingHours {
    private String day;
    private String startTime;
    private String endTime;

    public WorkingHours(String day, String startTime, String endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static List<WorkingHours> getWorkingHours(String workingHours) {
        //todo: add logic to process working hours string
        final String[] split = workingHours.split(",");
        List<String> daysOfTheWeek = Arrays.asList("SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY");
        List<WorkingHours> wh = new ArrayList<>();
        int count = 0;
        for (String s:split) {
            final String[] startEnd = s.split(":");
            wh.add(new WorkingHours(daysOfTheWeek.get(count++),startEnd[0],startEnd[1]));
        }

        return wh;
    }
}
