package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Position represents the current position and direction of the maze runner.
 * It implements the SubjectList interface to notify observers of changes.
 */
public class Position implements SubjectList {

    private int[] position; // Current position as [row, col]
    private Direction direction = Direction.EAST; // Current direction of the runner
    private final List<Observer> observers = new ArrayList<>(); // List of observers

    /**
     * Constructor for Position.
     *
     * @param position The initial position as [row, col].
     */
    Position(int[] position) {
        this.position = position;
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers of changes to the Position object.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.updateValues(this); // Pass the current Position object
        }
    }

    /**
     * Sets the current position and notifies observers.
     *
     * @param position The new position as [row, col].
     */
    public void setPosition(int[] position) {
        this.position = position;
        this.notifyObservers();
    }

    /**
     * Moves the position by a specified number of rows and notifies observers.
     *
     * @param row The number of rows to move.
     */
    public void moveRow(int row) {
        position[0] += row;
        this.notifyObservers();
    }

    /**
     * Moves the position by a specified number of columns and notifies observers.
     *
     * @param col The number of columns to move.
     */
    public void moveCol(int col) {
        position[1] += col;
        this.notifyObservers();
    }

    /**
     * Gets the current position.
     *
     * @return The current position as [row, col].
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * Peeks at the position directly forward based on the current direction.
     *
     * @return The position forward as [row, col].
     */
    public int[] peekForward() {
        if (direction.equals(Direction.NORTH)) {
            return new int[]{position[0] - 1, position[1]};
        } else if (direction.equals(Direction.SOUTH)) {
            return new int[]{position[0] + 1, position[1]};
        } else if (direction.equals(Direction.EAST)) {
            return new int[]{position[0], position[1] + 1};
        } else if (direction.equals(Direction.WEST)) {
            return new int[]{position[0], position[1] - 1};
        }
        return position;
    }

    /**
     * Peeks at the position directly to the left based on the current direction.
     *
     * @return The position to the left as [row, col].
     */
    public int[] peekLeft() {
        if (direction.equals(Direction.NORTH)) {
            return new int[]{position[0], position[1] - 1};
        } else if (direction.equals(Direction.SOUTH)) {
            return new int[]{position[0], position[1] + 1};
        } else if (direction.equals(Direction.EAST)) {
            return new int[]{position[0] - 1, position[1]};
        } else if (direction.equals(Direction.WEST)) {
            return new int[]{position[0] + 1, position[1]};
        }
        return position;
    }

    /**
     * Peeks at the position directly to the right based on the current direction.
     *
     * @return The position to the right as [row, col].
     */
    public int[] peekRight() {
        if (direction.equals(Direction.NORTH)) {
            return new int[]{position[0], position[1] + 1};
        } else if (direction.equals(Direction.SOUTH)) {
            return new int[]{position[0], position[1] - 1};
        } else if (direction.equals(Direction.EAST)) {
            return new int[]{position[0] + 1, position[1]};
        } else if (direction.equals(Direction.WEST)) {
            return new int[]{position[0] - 1, position[1]};
        }
        return position;
    }

    /**
     * Sets the current direction and notifies observers.
     *
     * @param direction The new direction.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
        this.notifyObservers();
    }

    /**
     * Gets the current direction.
     *
     * @return The current direction.
     */
    public Direction getDirection() {
        return direction;
    }
}
