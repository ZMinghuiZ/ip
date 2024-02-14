package task;
public class Task {
    protected boolean isDone;
    protected final String description;

    public Task(String description) {
        this.isDone = false;
        this.description = description;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        String status = isDone ? "X" : " ";
        return "[" + status + "] " + description;
    }
}