package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MazeTest {

    @Test
    public void testGetRowLength(){
        Maze maze = new Maze("examples/straight.maz.txt");
        assertEquals(maze.getRowLength(), 5);
    }

    @Test
    public void testGetColLength(){
        Maze maze = new Maze("examples/straight.maz.txt");
        assertEquals(maze.getColLength(), 5);
    }

    @Test
    public void testGetMazeIndex(){
        Maze maze = new Maze("examples/straight.maz.txt");
        assertEquals(maze.getMazeIndex(0, 0), "#");
    }
}
