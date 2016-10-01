package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearNoteBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.RecordNotesRequest;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ivan on 29.09.2016.
 */
public class RecordNotes implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        RecordNotesRequest req = null;

        if (request instanceof ClearNoteBookRequest) {
            req = (RecordNotesRequest) request;
        } else {

            throw new CommandException("Wrong request");
        }

        List<Note> list = NoteBookProvider.getInstance().getNoteBook().getNotes();

        try {
            FileWriter fw = new FileWriter(req.getPath(), true);
            for (Note someNote : list) {
                String note = someNote.getSomeNote();
                String date = someNote.getNoteDate().toString();
                fw.write("[" + date + "] " + note + "\r\n"); //[ 2016-10-01 } some note
            }
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("File recorded");
        return response;
    }
}
