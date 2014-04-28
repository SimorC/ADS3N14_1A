package app;

import utils.*;
import controller.*;

public class Main {
	public static void main(String[] args) {
		// Initialize the app
		(new ContactFile()).createContacts(20);
		AppController controller = new AppController();
		controller.showContact();
	}
}