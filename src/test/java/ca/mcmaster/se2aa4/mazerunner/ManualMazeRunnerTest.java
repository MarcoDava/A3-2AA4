package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManualMazeRunnerTest {

    @Test
    void testManualMazeRunnerSuccess() {
        Maze maze = new Maze("examples/tiny.maz.txt");
        ManualMazeRunner runner = new ManualMazeRunner(maze, "FFRFF");
        assertFalse(runner.MazeRunnerAlgorithm());
    }

    @Test
    void testManualMazeRunnerFailure() {
        Maze maze = new Maze("examples/tiny.maz.txt");
        ManualMazeRunner runner = new ManualMazeRunner(maze, "FFFF");
        assertFalse(runner.MazeRunnerAlgorithm());
    }
}
