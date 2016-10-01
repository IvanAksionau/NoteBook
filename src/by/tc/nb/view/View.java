package by.tc.nb.view;

import by.tc.nb.bean.AddNewNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		System.out.println("Выберите команду : " + "\r\n"
                 + 1 + " - Добавить запись " + "\r\n" + 2
                + " - Очистить блокнот");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int readData = Integer.parseInt(reader.readLine());


		switch (readData){
            case 1:
                AddNewNoteRequest request1 = new AddNewNoteRequest();
                request1.setCommandName("ADD_NEW_NOTE");
                System.out.println("Введите строку для добавления");
                request1.setNote(reader.readLine());
                Response response = controller.doRequest(request1);
                if(response.isErrorStatus() ==  false){
                    System.out.println(response.getResultMessage());
                }else{
                    System.out.println(response.getErrorMessage());
                }
                break;
            case 2:
                Request request2 = new Request();
                request2.setCommandName("CLEAR_NOTE_BOOK");
                Response response2 = controller.doRequest(request2);
                if(response2.isErrorStatus() ==  false){
                    System.out.println(response2.getResultMessage());
                }else{
                    System.out.println(response2.getErrorMessage());
                }
                break;

        }
		
	/*	AddNewNoteRequest request = new AddNewNoteRequest();
		//request.setCommandName("ADD_NEW_NOTE");
		//request.setNote("my message");
		request.setCommandName("ADD_NEW_NOTE");
		request.setNote("ghghghggh");
		Response response = controller.doRequest(request);

		if(response.isErrorStatus() ==  false){
			System.out.println(response.getResultMessage());
		}else{
			System.out.println(response.getErrorMessage());
		}*/

		
		
	}

}
