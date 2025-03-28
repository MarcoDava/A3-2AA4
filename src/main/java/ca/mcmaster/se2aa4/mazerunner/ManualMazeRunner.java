package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManualMazeRunner extends MazeRunner {
    private static final Logger logger = LogManager.getLogger();
    private final Position position;
    private final Exit exit;
    private final Entry entry;
    private final String inputMoves;
    private PositionObserver positionObserver;

    public ManualMazeRunner(Maze maze, String inputMoves) {
        super(maze);
        this.inputMoves = inputMoves;
        this.exit = new Exit(maze);
        this.entry = new Entry(maze);
        this.position = new Position(entry.getEntryPoint());
        this.positionObserver = new PositionObserver(position);
    }

    @Override
    public boolean MazeRunnerAlgorithm() {
        for (int i = 0; i < inputMoves.length(); i++) {
            char move = inputMoves.charAt(i);
            if (move == 'F') {
                if (!isWall(position.peekForward())) {
                    position.moveForward();
                } else {
                    logger.info("Cannot move forward");
                    return false;
                }
            } else if (move == 'R') {
                position.turnRight();
            } else if (move == 'L') {
                position.turnLeft();
            } else {
                logger.info("Invalid input");
                return false;
            }
        }
        if (Arrays.equals(position.getPosition(), exit.getExitPoint())) {
            logger.info("Maze has been solved");
            return true;
        }
        logger.info("Maze has not been solved");
        return false;
    }
}