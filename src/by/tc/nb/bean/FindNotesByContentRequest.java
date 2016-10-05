package by.tc.nb.bean;

/**
 * Created by Ivan on 04.10.2016.
 */
public class FindNotesByContentRequest extends Request {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
