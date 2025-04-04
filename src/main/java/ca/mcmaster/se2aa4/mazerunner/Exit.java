package ca.mcmaster.se2aa4.mazerunner;

/**
 * Exit identifies the exit point of the maze.
 */
public class Exit {
    private Maze maze; // The maze object

    /**
     * Constructor for Exit.
     *
     * @param maze The maze to analyze.
     */
    public Exit(Maze maze) {
        this.maze = maze;
    }

    /**
     * Gets the exit point of the maze.
     * The exit is the first open space (" ") in the last column of the maze.
     *
     * @return The exit point as [row, col], or null if no exit is found.
     */
    public int[] getExitPoint() {
        for (int i = 0; i < maze.getRowLength(); i++) {
            if (maze.getMazeIndex(i, maze.getColLength() - 1).equals(" ")) {
                return new int[]{i, maze.getColLength() - 1};
            }
        }
        return null;
    }
}