package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class NoteBookServiceImpl implements NoteBookService {
    @Override
    public void addNote(String note) throws ServiceException {
        // parameters validation
        if (note == null || "".equals(note)) {
            throw new ServiceException("Wrong parameter!");
        }
        Note newNote = new Note(note);
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.addNote(newNote);
    }

    @Override
    public void clearAllNotes() throws ServiceException {
        // parameters validation
        if (NoteBookProvider.getInstance().getNoteBook().getNotes().size() != 0) {
            throw new ServiceException("Notes were not founded!");
        }
        NoteBookProvider.getInstance().getNoteBook().clearNoteBook();
    }

    @Override
    public void recordNoteBook(String path) throws ServiceException {
        if (path == null || path.isEmpty()) {
            throw new ServiceException("Wrong path parameter!");
        }
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(noteBook);
            outputStream.close();
        } catch (FileNotFoundException ex) {
            throw new ServiceException("FileNotFound");
        } catch (IOException ex) {
            throw new ServiceException("IOException");
        }
    }

    @Override
    public void downLoadNoteBook(String path) throws ServiceException {
        if (path == null || path.isEmpty()) {
            throw new ServiceException("Wrong path parameter!");
        }
        NoteBook noteBook = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            noteBook = (NoteBook) inputStream.readObject();
            inputStream.close();
        } catch (FileNotFoundException ex) {
            throw new ServiceException("FileNotFound");
        } catch (IOException ex) {
            throw new ServiceException("IOException");
        } catch (ClassNotFoundException e) {
            throw new ServiceException("Not an object of class \"NoteBook\"");
        }
        NoteBookProvider.getInstance().setNoteBook(noteBook);
    }

    @Override
    public void ShowNotes() throws ServiceException {

        if (NoteBookProvider.getInstance().getNoteBook().getNotes().size() != 0) {
            throw new ServiceException("Notes were not founded!");
        }
        List<Note> list = NoteBookProvider.getInstance().getNoteBook().getNotes();
        for (Note someNote : list) {
            String note = someNote.getSomeNote();
            String date = someNote.getNoteDate().toString();
            System.out.println("[" + date + "]" + note + "\r\n");
        }
    }

    @Override
    public List<Note> findNotesByContent(String content) throws ServiceException {
        if (content == null || "".equals(content)) {
            throw new ServiceException("Wrong parameter!");
        }
        List<Note> result = new ArrayList<>();
        List<Note> list = NoteBookProvider.getInstance().getNoteBook().getNotes();
        for (Note someNote : list) {
            String note = someNote.getSomeNote();
            if (note.contains(content)){
                result.add(someNote);
            }
        }
        return result;
    }

    @Override
    public List<Note> findNotesByDate(String year, String month, String dayOfMonth) throws ServiceException {
        if (year == null || month == null || dayOfMonth == null) {
            throw new ServiceException("Wrong parameter!");
        }
        try {
            int dateYear = parseInt(year);
            int dateMonth = parseInt(month);
            int dateDayOfMonth = parseInt(dayOfMonth);

            String requestDate = LocalDate.of(dateYear, dateMonth, dateDayOfMonth).toString();
            List<Note> result = new ArrayList<>();
            List<Note> list = NoteBookProvider.getInstance().getNoteBook().getNotes();
            for (Note someNote : list) {
                String noteDate = someNote.getNoteDate().toString();
                if (requestDate.equals(noteDate)) {
                    result.add(someNote);
                }
            }
            return result;
        }
        catch (NumberFormatException ex){
            throw new ServiceException("Wrong parameter!");
        }

    }


}
