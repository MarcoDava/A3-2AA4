package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

public class AutomaticMazeRunner extends MazeRunner implements Observer {
    private final Path path = new Path();
    private Position position;
    private final Exit exit;
    private final Entry entry;

    public AutomaticMazeRunner(Maze maze) {
        super(maze);
        exit = new Exit(maze);
        entry = new Entry(maze);
        position = new Position(entry.getEntryPoint());
    }

    @Override 
    public void updateValues(Position position){
        this.position=position;
    } 

    @Override
    public boolean MazeRunnerAlgorithm() {
        boolean atEnd = false;
        Command command;
        while (!atEnd) {
            if (!isWall(position.peekRight())) {
                command=new MoveRightCommand(position);
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
            return true;
        } else {
            return false;
        }
    }
}