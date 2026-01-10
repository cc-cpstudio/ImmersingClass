package backend.timetable;

public class TooManyLessonsEnabled extends RuntimeException {
    public TooManyLessonsEnabled() {
        super("可用课程表太多以至于不能执行后续操作");
    }
}
