package ca.mcmaster.se2aa4.mazerunner;

/**
 * SubjectList defines the interface for a subject in the Observer pattern.
 * It allows observers to be added, removed, and notified of changes.
 */
public interface SubjectList {
    /**
     * Adds an observer to the subject.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(Observer observer);

    /**
     * Removes an observer from the subject.
     *
     * @param observer The observer to be removed.
     */
    public void removeObserver(Observer observer);

    /**
     * Notifies all observers of changes to the subject.
     */
    public void notifyObservers();
}