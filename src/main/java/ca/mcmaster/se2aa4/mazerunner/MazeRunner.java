package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MazeRunner {
    private static final Logger logger = LogManager.getLogger();
    private Maze maze;
    private Entry entry;

    public MazeRunner(Maze maze) {
        this.maze = maze;
        entry = new Entry(maze);
    }

    public abstract boolean MazeRunnerAlgorithm();

    public boolean isWall(int[] position) {
        int row=position[0];
        int col=position[1];
        if(maze.getMazeIndex(row,col).equals("#")){
            return true;
        }
        return false;
    }

}