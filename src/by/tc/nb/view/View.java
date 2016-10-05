package by.tc.nb.view;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final Controller controller = new Controller();
    private static final Scanner scanner = new Scanner(System.in);
    private static String help = "Enter : " + "\r\n"
            + "1 - Add new note into notebook" + "\r\n"
            + "2 - Clear the notebook" + "\r\n"
            + "3 - Download note book" + "\r\n"
            + "4 - Find notes by content" + "\r\n"
            + "5 - Find notes by date" + "\r\n"
            + "6 - Record the notebook" + "\r\n"
            + "7 - Show all notes";

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Enter \"help\" in order to get the CommandMenu, or \"e\" to exit");
            String Command = scanner.nextLine();

            if (Command.equals("e")) {
                System.out.println("Program finished!");
                break;
            }
            switch (Command) {
                case "help":
                    System.out.println(help);
                    break;
                case "1"://AddNewNote
                    AddNewNoteRequest request1 = new AddNewNoteRequest();
                    request1.setCommandName("ADD_NEW_NOTE");
                    System.out.println("Enter new note :");
                    String message = new Scanner(System.in).nextLine();
                    request1.setNote(message);
                    Response response = controller.doRequest(request1);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getResultMessage());
                    } else {
                        System.out.println(response.getErrorMessage());
                    }
                    break;
                case "2"://ClearNoteBook
                    ClearNoteBookRequest request2 = new ClearNoteBookRequest();
                    request2.setCommandName("CLEAR_NOTE_BOOK");
                    Response response2 = controller.doRequest(request2);
                    if (response2.isErrorStatus() == false) {
                        System.out.println(response2.getResultMessage());
                    } else {
                        System.out.println(response2.getErrorMessage());
                    }
                    break;
                case "3"://DownloadNoteBook
                    DownloadNoteBookRequest request3 = new DownloadNoteBookRequest();
                    request3.setCommandName("DOWNLOAD_NOTE_BOOK");
                    System.out.println("Enter path for download :");
                    request3.setPath(scanner.nextLine());
                    Response response3 = controller.doRequest(request3);

                    if (response3.isErrorStatus() == false) {
                        System.out.println(response3.getResultMessage());
                    } else {
                        System.out.println(response3.getErrorMessage());
                    }
                    break;
                case "4"://FindNotesByContent
                    FindNotesByContentRequest request4 = new FindNotesByContentRequest();
                    request4.setCommandName("FIND_NOTES_BY_CONTENT");
                    System.out.println("Enter content for finding :");
                    request4.setContent(scanner.nextLine());
                    FindNotesByContentResponse response4 = (FindNotesByContentResponse) controller.doRequest(request4);

                    if (response4.isErrorStatus() == false) {
                        System.out.println(response4.getResultMessage());
                        List<Note> result = response4.getFoundedNotes();
                        for (Note note : result) {
                            System.out.println(note.getSomeNote());
                        }
                    } else {
                        System.out.println(response4.getErrorMessage());
                    }
                    break;
                case "5"://FindNotesByDate
                    FindNotesByDateRequest request5 = new FindNotesByDateRequest();
                    request5.setCommandName("FIND_NOTE_BY_DATE");
                    System.out.println("Enter year of creation in format yyyy :");
                    request5.setYear(scanner.nextLine());
                    System.out.println("Enter month of creation in format mm :");
                    request5.setMonth(scanner.nextLine());
                    System.out.println("Enter day of month of creation in format dd :");
                    request5.setDayOfMonth(scanner.nextLine());
                    FindNotesByDateResponse response5 = (FindNotesByDateResponse) controller.doRequest(request5);

                    if (response5.isErrorStatus() == false) {
                        System.out.println(response5.getResultMessage());

                        List<Note> result = response5.getFoundedNotes();
                        for (Note note : result) {
                            System.out.println(note.getSomeNote());
                        }
                    } else {
                        System.out.println(response5.getErrorMessage());
                    }
                    break;
                case "6"://RecordNoteBook
                    RecordNotesRequest request6 = new RecordNotesRequest();
                    request6.setCommandName("RECORD_NOTES");
                    System.out.println("Enter path for record :");
                    request6.setPath(scanner.nextLine());
                    Response response6 = controller.doRequest(request6);

                    if (response6.isErrorStatus() == false) {
                        System.out.println(response6.getResultMessage());
                    } else {
                        System.out.println(response6.getErrorMessage());
                    }
                    break;
                case "7"://ShowNotes
                    ShowNotesRequest request7 = new ShowNotesRequest();
                    request7.setCommandName("SHOW_NOTES");
                    Response response7 = controller.doRequest(request7);
                    if (response7.isErrorStatus() == false) {
                        System.out.println(response7.getResultMessage());
                    } else {
                        System.out.println(response7.getErrorMessage());
                    }
                    break;
            }
        }
    }
}
