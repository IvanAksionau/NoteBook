package by.tc.nb.source;

import by.tc.nb.bean.entity.NoteBook;

public class NoteBookProvider {
	private static final NoteBookProvider instance = new NoteBookProvider();
	
	private NoteBook noteBook;
	
	private NoteBookProvider(){
		noteBook = new NoteBook();
	}
	
	
	public static NoteBookProvider getInstance(){
		return instance;
	}

	public void setNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}

	public NoteBook getNoteBook(){
		return noteBook;
	} ///why not static

}
