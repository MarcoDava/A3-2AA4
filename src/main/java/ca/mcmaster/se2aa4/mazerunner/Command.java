package ca.mcmaster.se2aa4.mazerunner;

public abstract class Command {
    protected Position position;
    protected Direction direction;
    public Command(Position position){
        this.position=position;
        direction=position.getDirection();
    }

    public abstract void execute();
}