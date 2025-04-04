package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

/**
 * ManualMazeRunner is responsible for solving the maze manually based on a predefined sequence of moves.
 * It implements the Observer interface to react to position updates.
 */
public class ManualMazeRunner extends MazeRunner implements Observer {
    private Position position; // Current position of the runner
    private final Exit exit; // Exit point of the maze
    private final Entry entry; // Entry point of the maze
    private final String inputMoves; // Sequence of moves provided by the user

    /**
     * Constructor for ManualMazeRunner.
     * Initializes the maze, entry, exit, and position.
     * Registers itself as an observer of the position.
     *
     * @param maze The maze to solve.
     * @param inputMoves The sequence of moves to solve the maze.
     */
    public ManualMazeRunner(Maze maze, String inputMoves) {
        super(maze);
        this.inputMoves = inputMoves;
        this.exit = new Exit(maze);
        this.entry = new Entry(maze);
        this.position = new Position(entry.getEntryPoint());
        position.addObserver(this);
    }

    /**
     * Updates the position when notified by the subject (Position).
     *
     * @param updatedPosition The updated position object.
     */
    @Override
    public void updateValues(Position updatedPosition) {
        this.position = updatedPosition; 
    }

    /**
     * Executes the maze-solving algorithm based on the input moves.
     *
     * @return true if the maze is solved, false otherwise.
     */
    @Override
    public boolean MazeRunnerAlgorithm() {
        for (int i = 0; i < inputMoves.length(); i++) {
            char move = inputMoves.charAt(i);
            Command command;
            if (move == 'F') {
                if (!isWall(position.peekForward())) {
                    command = new ForwardCommand(position);
                } else {
                    System.out.println("incorrect path");
                    return false;
                }
            } else if (move == 'R') {
                command = new RightCommand(position);
            } else if (move == 'L') {
                command = new LeftCommand(position);
            } else {
                System.out.println("incorrect path");
                return false;
            }
            command.execute();
        }
        if (Arrays.equals(position.getPosition(), exit.getExitPoint())) {
            System.out.println("correct path");
            return true;
        }
        System.out.println("incorrect path");
        return false;
    }
}