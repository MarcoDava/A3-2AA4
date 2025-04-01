package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void testMoveNorth() {
        Position position = new Position(new int[]{1, 1});
        position.moveRow(1);
        assertArrayEquals(new int[]{2, 1}, position.getPosition());
    }
}
