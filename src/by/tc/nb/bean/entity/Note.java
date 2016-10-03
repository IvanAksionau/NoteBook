package by.tc.nb.bean.entity;

import java.time.LocalDate;

public class Note {
    private String someNote;
    private LocalDate noteDate;

    public Note(String someNote) {
        this.someNote = someNote;
        noteDate = LocalDate.now();
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public String getSomeNote() {
        return someNote;
    }
}
