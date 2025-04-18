package ca.mcmaster.se2aa4.mazerunner;

public class MoveLeftCommand extends Command{
    public MoveLeftCommand(Position position){
        super(position);
    }

    @Override
    public void execute(){
        if (direction.equals(Direction.NORTH)){
            position.setDirection(Direction.WEST);
            position.moveCol(-1);
        } else if (direction.equals(Direction.SOUTH)){
            position.setDirection(Direction.EAST);
            position.moveCol(1);
        } else if (direction.equals(Direction.EAST)){
            position.setDirection(Direction.NORTH);
            position.moveRow(-1);
        } else if (direction.equals(Direction.WEST)){
            position.setDirection(Direction.SOUTH);
            position.moveRow(1);
        }
    }
}