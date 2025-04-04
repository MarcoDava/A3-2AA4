package ca.mcmaster.se2aa4.mazerunner;

/**
 * MazeRunner is an abstract class that defines the common behavior for maze-solving algorithms.
 */
public abstract class MazeRunner {
    protected Path path = new Path(); // Tracks the path taken by the runner
    protected Position position; // Current position of the runner
    protected Maze maze; // The maze to solve
    protected Exit exit; // Exit point of the maze
    protected Entry entry; // Entry point of the maze
    protected String inputMoves; // Sequence of moves (for manual runners)

    /**
     * Constructor for MazeRunner.
     * Initializes the maze, entry, exit, and position.
     *
     * @param maze The maze to solve.
     */
    public MazeRunner(Maze maze) {
        this.maze = maze;
        this.exit = new Exit(maze);
        this.entry = new Entry(maze);
        this.position = new Position(entry.getEntryPoint());
    }

    /**
     * Abstract method to execute the maze-solving algorithm.
     *
     * @return true if the maze is solved, false otherwise.
     */
    public abstract boolean MazeRunnerAlgorithm();

    /**
     * Checks if a given position is a wall.
     *
     * @param position The position to check as [row, col].
     * @return true if the position is a wall, false otherwise.
     */
    public boolean isWall(int[] position) {
        int row = position[0];
        int col = position[1];
        return maze.getMazeIndex(row, col).equals("#");
    }
}