package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void scanMazeTest(String inputFile) {
        assertTrue(new Maze("examples/straight.maz.txt").equals("\n#####\n#####\n     \n#####\n#####"));
    }
    //test all the methods 
}
