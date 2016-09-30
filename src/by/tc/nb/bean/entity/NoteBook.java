package by.tc.nb.bean.entity;

import java.util.List;

public class NoteBook {
	private List<Note> notes;

	public List<Note> getNotes() {
		return notes;
	}

	public void addNote(Note note){
		notes.add(note);

	}
	public void clearNoteBook(){
		notes.clear();
	}

}
