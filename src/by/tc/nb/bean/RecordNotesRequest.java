package by.tc.nb.bean;

import by.tc.nb.bean.Request;

/**
 * Created by Ivan on 30.09.2016.
 */
public class RecordNotesRequest extends Request {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
