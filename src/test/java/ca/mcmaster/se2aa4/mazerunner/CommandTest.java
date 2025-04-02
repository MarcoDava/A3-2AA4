package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    void testForwardCommand() {
        Position position = new Position(new int[]{1,1});
        Command command = new ForwardCommand(position);
        command.execute();
        assertArrayEquals(new int[]{1, 2}, position.getPosition());
    }

    @Test
    void testRightCommand() {
        Position position = new Position(new int[]{1,1});
        Command command = new RightCommand(position);
        command.execute();
        assertTrue(position.getDirection().equals(Direction.SOUTH));
    }

    @Test
    void testLeftCommand() {
        Position position = new Position(new int[]{1,1});
        Command command = new LeftCommand(position);
        command.execute();
        assertTrue(position.getDirection().equals(Direction.NORTH));       
    }

    @Test 
    void testMoveLeftCommand(){
        Position position = new Position(new int []{2,1});
        Command command = new MoveLeftCommand(position);
        command.execute();
        assertArrayEquals(new int[]{3, 1}, position.getPosition());
    }

    @Test 
    void testMoveRightCommand(){
        Position position = new Position(new int []{2,1});
        Command command = new MoveRightCommand(position);
        command.execute();
        assertArrayEquals(new int[]{1, 1}, position.getPosition());
    }

    @Test
    void testTurnAroundCommand() {
        Position position = new Position(new int[]{1,2});
        Command command = new TurnAroundCommand(position);
        command.execute();
        assertTrue(position.getDirection().equals(Direction.WEST));       
        assertArrayEquals(new int[]{1,1},position.getPosition());
    }
}
