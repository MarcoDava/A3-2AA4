package ca.mcmaster.se2aa4.mazerunner;

/**
 * Observer defines the interface for observers in the Observer pattern.
 * Observers are notified of changes to the subject they are observing.
 */
public interface Observer {
    /**
     * Updates the observer with the latest state of the subject.
     *
     * @param position The updated position object.
     */
    public void updateValues(Position position);
}