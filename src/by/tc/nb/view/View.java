package by.tc.nb.view;

import by.tc.nb.bean.AddNewNoteRequest;
import by.tc.nb.bean.Response;
import by.tc.nb.controller.Controller;

public class View {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		
		AddNewNoteRequest request = new AddNewNoteRequest();
		//request.setCommandName("ADD_NEW_NOTE");
		//request.setNote("my message");
		request.setCommandName("CREATE_NEW_NOTE_BOOK");
		request.setNote("ghghghggh");
		Response response = controller.doRequest(request);

		
		if(response.isErrorStatus() ==  false){
			System.out.println(response.getResultMessage());
		}else{
			System.out.println(response.getErrorMessage());
			
		}

		
		
	}

}
