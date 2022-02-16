package za.co.momagano.model;

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
        return null;
    }
}
