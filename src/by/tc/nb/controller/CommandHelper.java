package by.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.*;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_NOTE", new AddNewNote());
		commands.put("CLEAR_NOTE_BOOK", new ClearNoteBook());
		commands.put("DOWNLOAD_NOTE", new DownloadNoteBook());
		commands.put("FIND_NOTES_BY_CONTENT", new FindNotesByContent());
		commands.put("FIND_NOT_BY_DATE", new FindNotesByDate());
		commands.put("RECORD_NOTES", new RecordNotes());
		commands.put("SHOW_NOTES", new ShowNotes());
	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}
