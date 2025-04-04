package ca.mcmaster.se2aa4.mazerunner;

public class ForwardCommand extends Command{
    public ForwardCommand(Position position){
        super(position);
    }

    @Override
    public void execute(){
        if (direction.equals(Direction.NORTH)) {
            position.moveRow(-1);
        } else if (direction.equals(Direction.SOUTH)) {
            position.moveRow(1);
        } else if (direction.equals(Direction.EAST)) {
            position.moveCol(1);
        } else if (direction.equals(Direction.WEST)) {
            position.moveCol(-1);
        }
    }
}