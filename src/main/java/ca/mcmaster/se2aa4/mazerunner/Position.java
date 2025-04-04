package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Position implements SubjectList {

    private int[] position;
    private Direction direction = Direction.EAST;
    private final List<Observer> observers = new ArrayList<>();

    Position(int[] position) {
        this.position = position;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.updateValues(this); // Pass the current Position object
        }
    }

    public void setPosition(int[] position) {
        this.position = position;
        this.notifyObservers();
    }

    public void moveRow(int row) {
        position[0] += row;
        this.notifyObservers();
    }

    public void moveCol(int col) {
        position[1] += col;
        this.notifyObservers();
    }

    public int[] getPosition() {
        return position;
    }

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

    public void setDirection(Direction direction) {
        this.direction = direction;
        this.notifyObservers();
    }

    public Direction getDirection() {
        return direction;
    }
}
