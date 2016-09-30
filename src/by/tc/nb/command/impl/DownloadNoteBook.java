package by.tc.nb.command.impl;

import by.tc.nb.bean.DownloadNoteBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

/**
 * Created by Ivan on 29.09.2016.
 */
public class DownloadNoteBook implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        DownloadNoteBookRequest req = null;

        if (request instanceof DownloadNoteBookRequest) {
            req = (DownloadNoteBookRequest) request;
        } else {

            throw new CommandException("Wrong request");
        }

       /*String note = req.getNote();

      //  Note newNote = new Note(note);

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.addNote(newNote);*/

        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("All OK/запись добавлена в блокнот!");


        return response;
    }
}
