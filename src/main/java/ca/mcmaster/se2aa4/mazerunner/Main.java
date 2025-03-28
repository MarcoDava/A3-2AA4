package ca.mcmaster.se2aa4.mazerunner;

public class Main {//dont forget to remove all logging statements

    public static void main(String[] args) {
        Maze maze = new Maze("examples/tiny.maz.txt");
        MazeRunner runner = new ManualMazeRunner(maze, "FFRFF");
        runner.MazeRunnerAlgorithm();
    }
}