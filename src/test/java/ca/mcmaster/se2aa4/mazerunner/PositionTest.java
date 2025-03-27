package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testMoveForward() {
        Position position = new Position(new int[]{1, 1});
        position.moveForward();
        assertArrayEquals(new int[]{1, 2}, position.getPosition());
    }

    @Test
    void testTurnLeft() {
        Position position = new Position(new int[]{1, 1});
        position.turnLeft();
        assertArrayEquals(new int[]{1, 0}, position.peekForward());
    }

    @Test
    void testTurnRight() {
        Position position = new Position(new int[]{1, 1});
        position.turnRight();
        assertArrayEquals(new int[]{2, 1}, position.peekForward());
    }
}
