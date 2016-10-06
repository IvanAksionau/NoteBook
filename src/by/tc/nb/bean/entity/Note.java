package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {

    private String note;
    private LocalDate noteDate;

    public Note(String note) {
        this.note = note;
        noteDate = LocalDate.now();
    }

    public void setNoteDate(int year, int month, int dayOfMonth) {
        this.noteDate = LocalDate.of(year, month, dayOfMonth);
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNoteDate(LocalDate noteDate) {
        this.noteDate = noteDate;
    }

    public String getNote() {
        return note;
    }
}
