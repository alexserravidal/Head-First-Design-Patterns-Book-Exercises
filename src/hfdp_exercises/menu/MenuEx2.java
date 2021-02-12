package hfdp_exercises.menu;

import java.util.Timer;
import java.util.TimerTask;

import hfdp_exercises.ex2_observer_pattern.DisplayCurrentConditions;
import hfdp_exercises.ex2_observer_pattern.WeatherData;

public class MenuEx2 extends Menu {
	
	WeatherData weatherData = new WeatherData();
	
	DisplayCurrentConditions currentConditionsDisplay = new DisplayCurrentConditions(weatherData);
	
	Timer timer = new Timer();
	TimerTask timerTask = null;
	int timerCounter = 10;
	
	boolean showMenu = true;
	
	@Override
	void printHeader() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------" + "\n");
		System.out.println("                     Exercise 2: Observer pattern                 " + "\n");
		System.out.println("");
		System.out.println("We got a WeatherData station that displays its data every 5 sec   " + "\n");
		System.out.println("------------------------------------------------------------------" + "\n\n");
	}

	@Override
	void printMenu() {
		if (showMenu) {
			System.out.println("     1) Check data for the next 20 sec                            " + "\n");
			System.out.println("     0) Back to menu                                              ");
		}
	}

	@Override
	void performAction(int choice) {
		switch(choice) {
			case 0:
				exit();
				swapMenu(MenusEnum.MAIN_MENU);
				break;
			case 1:
				startWeatherStation();
				break;
			case 2:
				stopWeatherStation();
				break;
			default:
				System.out.println("Unexpected error occurred");
				break;
		}
	}
	
	@Override
	boolean isChoiceValid(int choice) {
		return choice == 0 || choice == 1 || choice == 2;		
	}
	
	private void startWeatherStation() {
		setMenuVisibility(false);
		timerCounter = 10;
		timer = new Timer();
		if (timerTask == null) {
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					float temperature = (float) ((Math.random() * (82f - 78f)) + 78f);
					float humidity = (float) ((Math.random() * (82f - 68f)) + 68f);
					float pressure = (float) ((Math.random() * (30.4f - 29.2f)) + 29.2f);
					weatherData.setMeasurements(temperature, humidity, pressure);
					timerCounter--;
					if (timerCounter == 0) {
						stopWeatherStation();
					}
				}
			};
			timer.schedule(timerTask, 0, 2000);
		}
	}
	
	private void stopWeatherStation() {
		setMenuVisibility(true);
		timer.cancel();
		timerTask = null;
	}
}
