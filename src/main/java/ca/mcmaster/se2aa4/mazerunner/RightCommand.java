package ca.mcmaster.se2aa4.mazerunner;

public class RightCommand extends Command{
    public RightCommand(Position position){
        super(position);
    }

    @Override
    public void execute(){
        if (direction.equals(Direction.NORTH)) {
            position.setDirection(Direction.EAST);
        } else if (direction.equals(Direction.SOUTH)) {
            position.setDirection(Direction.WEST);
        } else if (direction.equals(Direction.EAST)) {
            position.setDirection(Direction.SOUTH);
        } else if (direction.equals(Direction.WEST)) {
            position.setDirection(Direction.NORTH);
        }
    }
}