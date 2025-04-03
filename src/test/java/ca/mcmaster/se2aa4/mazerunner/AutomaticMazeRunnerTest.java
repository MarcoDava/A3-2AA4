package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AutomaticMazeRunnerTest {

    @Test
    void testAutomaticMazeRunnerSuccess() {
        Maze maze = new Maze("examples/tiny.maz.txt");
        AutomaticMazeRunner runner = new AutomaticMazeRunner(maze);
        assertTrue(runner.MazeRunnerAlgorithm());
    }

    @Test
    void testAutomaticMazeRunnerSuccessHarder() {
        Maze maze = new Maze("examples/giant.maz.txt");
        AutomaticMazeRunner runner = new AutomaticMazeRunner(maze);
        assertTrue(runner.MazeRunnerAlgorithm());
    }

    @Test
    void testIsWall() {
        Maze maze = new Maze("examples/straight.maz.txt");
        AutomaticMazeRunner runner = new AutomaticMazeRunner(maze);
        assertTrue(runner.isWall(new int[]{0,0}));
    }
}
