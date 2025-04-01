package ca.mcmaster.se2aa4.mazerunner;

public interface SubjectList{
    public void addObserver(Observer observer);
    
    public void removeObserver(Observer observer);

    public void notifyObservers();
}