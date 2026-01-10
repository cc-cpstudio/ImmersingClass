package backend.timetable;

public class TooLessTimetable extends RuntimeException {
    public TooLessTimetable() {
        super("时间表太少以至于不能执行后续操作");
    }
}
