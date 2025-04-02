package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ManualMazeRunnerTest {

    @Test
    void testManualMazeRunnerSuccess() {
        Maze maze = new Maze("examples/straight.maz.txt");
        ManualMazeRunner runner = new ManualMazeRunner(maze, "FFF");
        assertTrue(runner.MazeRunnerAlgorithm());
    }

    @Test
    void testManualMazeRunnerFailure() {
        Maze maze = new Maze("examples/tiny.maz.txt");
        ManualMazeRunner runner = new ManualMazeRunner(maze, "FFFF");
        assertFalse(runner.MazeRunnerAlgorithm());
    }
}
