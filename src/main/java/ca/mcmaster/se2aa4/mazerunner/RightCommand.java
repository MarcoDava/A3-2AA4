package ca.mcmaster.se2aa4.mazerunner;

/**
 * RightCommand changes the direction of the runner to the right.
 */
public class RightCommand extends Command {
    /**
     * Constructor for RightCommand.
     *
     * @param position The current position of the runner.
     */
    public RightCommand(Position position) {
        super(position);
    }

    /**
     * Executes the command to turn the runner to the right.
     */
    @Override
    public void execute() {
        if (direction.equals(Direction.NORTH)) {
            position.setDirection(Direction.EAST);
        } else if (direction.equals(Direction.SOUTH)) {
            position.setDirection(Direction.WEST);
        } else if (direction.equals(Direction.EAST)) {
            position.setDirection(Direction.SOUTH);
        } else if (direction.equals(Direction.WEST)) {
            position.setDirection(Direction.NORTH);
        }
    }
}