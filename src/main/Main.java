package main;

import enviroment.Controller;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Controller controller = new Controller("program/main.Main");
		controller.run();
	}

}