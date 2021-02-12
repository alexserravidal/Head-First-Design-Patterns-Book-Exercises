package hfdp_exercises.ex2_observer_pattern;

public class DisplayCurrentConditions implements DisplayElement, Observer {
	private float temperature;
	private float humidity;
	private WeatherData weatherData;
	
	public DisplayCurrentConditions(WeatherData wd) {
		weatherData = wd;
		weatherData.getSubject().registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("\n          -> Display Current Conditions: " + temperature + " F degrees and " + humidity + "% humidity\n");
	}

	@Override
	public void update() {
		temperature = weatherData.getTemperature();
		humidity = weatherData.getHumidity();
		display();
	}

}
