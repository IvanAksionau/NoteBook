package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public class FindNotesByContentResponse extends Response {
	private List<Note> foundedNotes;

	public List<Note> getFoundedNotes() {
		return foundedNotes;
	}

	public void setFoundedNotes(List<Note> foundedNotes) {
		this.foundedNotes = foundedNotes;
	}

	
}
