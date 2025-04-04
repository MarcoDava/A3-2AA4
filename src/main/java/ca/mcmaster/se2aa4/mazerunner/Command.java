package ca.mcmaster.se2aa4.mazerunner;

/**
 * Command is an abstract class that defines the structure for commands
 * that manipulate the position and direction of the maze runner.
 */
public abstract class Command {
    protected Position position; // The current position of the runner
    protected Direction direction; // The current direction of the runner

    /**
     * Constructor for Command.
     *
     * @param position The current position of the runner.
     */
    public Command(Position position) {
        this.position = position;
        this.direction = position.getDirection();
    }

    /**
     * Executes the command.
     */
    public abstract void execute();
}