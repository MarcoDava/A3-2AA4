package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class ExitTest {

    @Test
    void testExit() {
        Maze maze = new Maze("examples/straight.maz.txt");
        Exit exit = new Exit(maze);
        assertArrayEquals(new int[]{2, 4}, exit.getExitPoint());
    }
}
