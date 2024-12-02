package ownUtil;

public interface Observable {
	
	public abstract void addObserver(Observer obs);
	
	public abstract void removeObserver(Observer obs);
	
	public abstract void notifyObserver();
}
