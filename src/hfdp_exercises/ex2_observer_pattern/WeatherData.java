package hfdp_exercises.ex2_observer_pattern;

public class WeatherData {
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject subject = new Subject();

	public Subject getSubject() {
		return subject;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		subject.notifyObservers();
	}
}
