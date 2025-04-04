package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

/**
 * AutomaticMazeRunner is responsible for solving the maze automatically using a predefined algorithm.
 * It implements the Observer interface to react to position updates.
 */
public class AutomaticMazeRunner extends MazeRunner implements Observer {
    private final Path path = new Path(); // Tracks the path taken by the runner
    private Position position; // Current position of the runner
    private final Exit exit; // Exit point of the maze
    private final Entry entry; // Entry point of the maze

    /**
     * Constructor for AutomaticMazeRunner.
     * Initializes the maze, entry, exit, and position.
     * Registers itself as an observer of the position.
     *
     * @param maze The maze to solve.
     */
    public AutomaticMazeRunner(Maze maze) {
        super(maze);
        exit = new Exit(maze);
        entry = new Entry(maze);
        position = new Position(entry.getEntryPoint());
        position.addObserver(this);
    }

    /**
     * Updates the position when notified by the subject (Position).
     *
     * @param updatedPosition The updated position object.
     */
    @Override
    public void updateValues(Position updatedPosition) {
        this.position = updatedPosition; // Directly use the updated Position object
    }

    /**
     * Executes the maze-solving algorithm automatically.
     *
     * @return true if the maze is solved, false otherwise.
     */
    @Override
    public boolean MazeRunnerAlgorithm() {
        boolean atEnd = false;
        Command command;
        while (!atEnd) {
            if (!isWall(position.peekRight())) {
                command = new MoveRightCommand(position);
                path.addPath("RF");
            } else if (!isWall(position.peekForward())) {
                command = new ForwardCommand(position);
                path.addPath("F");
            } else if (!isWall(position.peekLeft())) {
                command = new MoveLeftCommand(position);
                path.addPath("LF");
            } else {
                command = new TurnAroundCommand(position);
                path.addPath("LLF");
            }
            command.execute();

            if (Arrays.equals(exit.getExitPoint(), position.getPosition())) {
                atEnd = true;
            }
        }
        if (Arrays.equals(position.getPosition(), exit.getExitPoint())) {
            System.out.println(path.getFactorizedPath());
            return true;
        } else {
            return false;
        }
    }
}