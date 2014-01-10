package main;

import enviroment.Controller;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		if (args.length < 1) {
			throw new IllegalStateException("Main class with main method has to be specified.");
		}
		Controller controller = new Controller(args);
		controller.run();
	}

}
