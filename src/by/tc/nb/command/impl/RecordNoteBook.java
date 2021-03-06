package by.tc.nb.command.impl;

import by.tc.nb.bean.RecordNotesRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

/**
 * Created by Ivan on 29.09.2016.
 */
public class RecordNoteBook implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        RecordNotesRequest req = null;

        if (request instanceof RecordNotesRequest) {
            req = (RecordNotesRequest) request;
        } else {

            throw new CommandException("Wrong request");
        }

        String path = req.getPath();
        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();

        try {
            nbService.recordNoteBook(path);
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }

        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("File recorded");
        return response;
    }
}
