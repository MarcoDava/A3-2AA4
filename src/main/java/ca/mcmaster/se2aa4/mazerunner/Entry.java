package ca.mcmaster.se2aa4.mazerunner;

/**
 * Entry identifies the entry point of the maze.
 */
public class Entry {
    private Maze maze; // The maze object

    /**
     * Constructor for Entry.
     *
     * @param maze The maze to analyze.
     */
    public Entry(Maze maze) {
        this.maze = maze;
    }

    /**
     * Gets the entry point of the maze.
     * The entry is the first open space (" ") in the first column of the maze.
     *
     * @return The entry point as [row, col], or null if no entry is found.
     */
    public int[] getEntryPoint() {
        for (int i = 0; i < maze.getRowLength(); i++) {
            if (maze.getMazeIndex(i, 0).equals(" ")) {
                return new int[]{i, 0};
            }
        }
        return null;
    }
}