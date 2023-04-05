package cs.design.pattern.behavariol.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	private int state;

	private List<Observer> observers = new ArrayList<>();

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

}
