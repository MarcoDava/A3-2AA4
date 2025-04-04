package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

public class ManualMazeRunner extends MazeRunner implements Observer {
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
        position.addObserver(this);
    }

    @Override
    public void updateValues(Position updatedPosition) {
        this.position = updatedPosition; 
    }

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