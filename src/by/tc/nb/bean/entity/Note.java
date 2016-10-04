package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {

    private String someNote;
    private LocalDate noteDate;

    public Note(String someNote) {
        this.someNote = someNote;
        noteDate = LocalDate.now();
    }

    public void setNoteDate(int year, int month, int dayOfMonth) {
        this.noteDate = LocalDate.of(year, month, dayOfMonth);
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public String getSomeNote() {
        return someNote;
    }
}
