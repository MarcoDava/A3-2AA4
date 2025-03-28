package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class SubjectList{
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : this.observers){
            observer.updateValues();
        }
    }
}