package ca.mcmaster.se2aa4.mazerunner;

public abstract class MazeRunner {
    protected Path path = new Path();
    protected Position position;
    protected Maze maze;
    protected Exit exit;
    protected Entry entry;
    protected String inputMoves;

    public MazeRunner(Maze maze) {
        this.maze = maze;
        this.exit = new Exit(maze);
        this.entry = new Entry(maze);
        this.position = new Position(entry.getEntryPoint());
    }

    public abstract boolean MazeRunnerAlgorithm();

    public boolean isWall(int[] position) {
        int row = position[0];
        int col = position[1];
        return maze.getMazeIndex(row, col).equals("#");
    }

}