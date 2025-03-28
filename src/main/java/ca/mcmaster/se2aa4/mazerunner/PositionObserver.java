package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class PositionObserver extends Observer {
    private static final Logger logger = LogManager.getLogger();

    public PositionObserver(SubjectList subjectList) {
        this.subjectList = subjectList;
        subjectList.addObserver(this);
    }

    @Override
    public void updateValues() {
        Position position = (Position) subjectList;
        int[] updatedPosition = position.getPosition();
    }
}