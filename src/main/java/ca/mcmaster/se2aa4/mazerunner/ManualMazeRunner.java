package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManualMazeRunner extends MazeRunner implements Observer{
    private static final Logger logger = LogManager.getLogger();
    private Position position;
    private final Exit exit;
    private final Entry entry;
    private final String inputMoves;

    public ManualMazeRunner(Maze maze, String inputMoves) {
        super(maze);
        this.inputMoves = inputMoves;
        this.exit = new Exit(maze);
        this.entry = new Entry(maze);
        this.position = new Position(entry.getEntryPoint());
    }

    @Override
    public void updateValues(Position position){
        this.position=position;
    }

    @Override
    public boolean MazeRunnerAlgorithm() {
        for (int i = 0; i < inputMoves.length(); i++) {
            char move = inputMoves.charAt(i);
            Command command;
            if (move == 'F') {
                if (!isWall(position.peekForward())) {
                    command=new ForwardCommand(position);
                } else {
                    return false;
                }
            } else if (move == 'R') {
                command = new RightCommand(position);
            } else if (move == 'L') {
                command = new LeftCommand(position);
            } else {
                logger.info("Invalid input");
                return false;
            }
            command.execute();
        }
        if (Arrays.equals(position.getPosition(), exit.getExitPoint())) {
            logger.info("Maze has been solved");
            return true;
        }
        logger.info("Maze has not been solved");
        return false;
    }
}