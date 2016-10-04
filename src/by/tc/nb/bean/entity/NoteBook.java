package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.util.List;

public class NoteBook implements Serializable{

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
