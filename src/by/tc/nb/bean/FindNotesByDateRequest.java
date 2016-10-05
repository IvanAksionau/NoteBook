package by.tc.nb.bean;

/**
 * Created by Ivan on 04.10.2016.
 */
public class FindNotesByDateRequest extends Request {
    private String year;
    private String month;
    private String dayOfMonth;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
