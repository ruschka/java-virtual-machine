package main;

import enviroment.Controller;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Controller controller = new Controller("file/Main");
		controller.run();
	}

}
