package ca.mcmaster.se2aa4.mazerunner;

class PositionObserver extends Observer{

    public PositionObserver(SubjectList subjectList){
        this.subjectList = subjectList;
        subjectList.addObserver(this);
    }
    
    @Override
    public void updateValues(){
        //update values
    }
}