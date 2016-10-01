package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearNoteBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;


public class ClearNoteBook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        ClearNoteBookRequest req = null;

        Response response = new Response();
        if (request instanceof ClearNoteBookRequest) {
            req = (ClearNoteBookRequest) request;
        } else {
            response.setErrorMessage("Notebook not cleared");
            throw new CommandException("Wrong request");
        }

        NoteBookProvider.getInstance().getNoteBook().clearNoteBook();
        response.setErrorStatus(false);
        response.setResultMessage("Notebook cleared");


        return response;
    }

}
