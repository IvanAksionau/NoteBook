package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

/**
 * Created by Ivan on 04.10.2016.
 */
public class FindNotesByDateResponse extends Response {
    private List<Note> foundedNotes;

    public List<Note> getFoundedNotes() {
        return foundedNotes;
    }

    public void setFoundedNotes(List<Note> foundedNotes) {
        this.foundedNotes = foundedNotes;
    }
}
