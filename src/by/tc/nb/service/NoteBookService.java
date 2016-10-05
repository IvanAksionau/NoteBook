package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.util.List;

public interface NoteBookService {
	
	void addNote(String note) throws ServiceException;
	void clearAllNotes() throws ServiceException;
	void recordNoteBook(String path) throws ServiceException;
	void downLoadNoteBook(String path) throws ServiceException;
	void ShowNotes() throws ServiceException;
	List<Note> findNotesByContent(String content) throws ServiceException;
	List<Note> findNotesByDate(String year, String month, String dayOfMonth) throws ServiceException;

}
