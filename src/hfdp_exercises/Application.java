package hfdp_exercises;

import java.io.IOException;

import hfdp_exercises.menu.Menu;

public class Application {
	public static void main(String[] args) throws IOException {
		Menu menu = Menu.getInstance();
		menu.runMenu();
	}
}
