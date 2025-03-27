package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void testMazeLoading() {
        Maze maze = new Maze(getClass().getClassLoader().getResource("tiny.maz.txt").getPath());
        assertNotNull(maze.getMaze());
        assertEquals(7, maze.getRowLength());
        assertEquals(7, maze.getColLength());
    }

    @Test
    void testMazeIndex() {
        Maze maze = new Maze(getClass().getClassLoader().getResource("tiny.maz.txt").getPath());
        assertEquals("#", maze.getMazeIndex(0, 0));
        assertEquals(" ", maze.getMazeIndex(1, 1));
    }
}
