package by.tc.nb.service;

import by.tc.nb.service.exception.ServiceException;

public interface NoteBookService {
	
	void addNote(String note) throws ServiceException;
	void clearAllNotes() throws ServiceException;
	void recordNoteBook(String path) throws ServiceException;
	void downLoadNoteBook(String path) throws ServiceException;
	void ShowNotes() throws ServiceException;

}
