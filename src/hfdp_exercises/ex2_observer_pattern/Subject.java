package hfdp_exercises.ex2_observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers;
	
	public Subject() {
		observers = new ArrayList<Observer>();
	}
	
	public List<Observer> getObservers() {
		return observers;
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
}
