package ca.mcmaster.se2aa4.mazerunner;

public class Position extends SubjectList{
    private int[] position;
    private Direction direction = Direction.EAST;//use observer for position
    //use either builder or factory to make the objects
    //
    Position(int[] position) {
        this.position = position;
        this.notifyObservers();
    }

    public void setPosition(int[] newPosition) {
        this.position = newPosition;
        this.notifyObservers();
    }
    public int[] getPosition(){
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

    public void turnLeft() {
        if (direction.equals(Direction.NORTH)) {
            direction=Direction.WEST;
        } else if (direction.equals(Direction.SOUTH)) {
            direction=Direction.EAST;
        } else if (direction.equals(Direction.EAST)) {
            direction=Direction.NORTH;
        } else if (direction.equals(Direction.WEST)) {
            direction=Direction.SOUTH;
        }
    }

    public void turnRight() {
        if (direction.equals(Direction.NORTH)) {
            direction=Direction.EAST;
        } else if (direction.equals(Direction.SOUTH)) {
            direction=Direction.WEST;
        } else if (direction.equals(Direction.EAST)) {
            direction=Direction.SOUTH;
        } else if (direction.equals(Direction.WEST)) {
            direction=Direction.NORTH;
        }
    }

    public void moveForward() {
        if (direction.equals(Direction.NORTH)) {
            position[0]--;
        } else if (direction.equals(Direction.SOUTH)) {
            position[0]++;
        } else if (direction.equals(Direction.EAST)) {
            position[1]++;
        } else if (direction.equals(Direction.WEST)) {
            position[1]--;
        }
        notifyObservers();
    }
}