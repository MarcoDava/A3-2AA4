package ca.mcmaster.se2aa4.mazerunner;

public class TurnAroundCommand extends Command{
    public TurnAroundCommand(Position position){
        super(position);
    }

    @Override
    public void execute(){
        if (direction.equals(Direction.NORTH)) {
            position.setDirection(Direction.SOUTH);
        } else if (direction.equals(Direction.SOUTH)) {
            position.setDirection(Direction.NORTH);
        } else if (direction.equals(Direction.EAST)) {
            position.setDirection(Direction.WEST);
        } else if (direction.equals(Direction.WEST)) {
            position.setDirection(Direction.EAST);
        }
    }
}