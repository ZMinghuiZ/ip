package task;

public class Event extends Task {
    private final String startTime;
    private final String dueTime;
    private static final int TASK_NAME_INDEX = 0;
    private static final int START_DATE_INDEX = 1;
    private static final int END_DATE_INDEX = 2;

    public Event(String[] eventInfo) {
        this(eventInfo[TASK_NAME_INDEX],
                eventInfo[END_DATE_INDEX],
                eventInfo[START_DATE_INDEX]);
    }
    Event(String description, String dueTime, String startTime) {
        super(description);
        this.startTime = startTime;
        this.dueTime = dueTime;
    }

    public boolean containsTime(String keyword) {
        return startTime.contains(keyword) || dueTime.contains(keyword);
    }

    @Override
    public String toString() {
        String status = isDone ? "X" : " ";
        return String.format("[E][%s] %s (from: %s to: %s)",
                status, description, startTime, dueTime);
    }
}
