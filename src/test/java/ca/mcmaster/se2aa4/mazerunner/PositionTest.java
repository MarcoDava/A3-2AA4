package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void testMoveNorth() {
        Position position = new Position(new int[]{1, 1});
        position.moveRow(1);
        assertArrayEquals(new int[]{2, 1}, position.getPosition());
    }
    @Test
    void testPeekRight(){
        Position position = new Position(new int[]{1, 1});
        assertArrayEquals(new int[]{2, 1}, position.peekRight());
    }
    @Test
    void testPeekLeft(){
        Position position = new Position(new int[]{2, 1});
        assertArrayEquals(new int[]{1, 1}, position.peekLeft());
    }
    @Test
    void testPeekForward(){
        Position position = new Position(new int[]{1, 1});
        assertArrayEquals(new int[]{1, 2}, position.peekForward());
    }
    @Test 
    void testSetDirection(){
        Position position = new Position(new int[]{1, 1});
        position.setDirection(Direction.NORTH);
        assertEquals(Direction.NORTH, position.getDirection());
    }
    @Test
    void testMoveCol(){
        Position position = new Position(new int[]{1, 1});
        position.moveCol(1);
        assertArrayEquals(new int[]{1, 2}, position.getPosition());
    }
    @Test
    void testMoveRow(){
        Position position = new Position(new int[]{1, 1});
        position.moveRow(1);
        assertArrayEquals(new int[]{2, 1}, position.getPosition());
    }
}
