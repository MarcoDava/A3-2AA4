package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    String[][] mazeArray;

    public Maze(String inputFile) {
        scanMaze(inputFile);
    }

    private String[][] scanMaze(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int rowCount = 0;
            while ((line = reader.readLine()) != null) {
                rowCount++;
            }
            reader.close();

            mazeArray = new String[rowCount][];
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
            int row = 0;
            while ((line = reader2.readLine()) != null) {
                mazeArray[row] = new String[line.length()];
                for (int index = 0; index < line.length(); index++) {
                    if (line.charAt(index) == '#') {
                        mazeArray[row][index] = "#";
                    } else if (line.charAt(index) == ' ') {
                        mazeArray[row][index] = " ";
                    }
                }
                row++;
            }
            reader2.close();
            
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
        return mazeArray;
    }

    public int getRowLength(){
        return mazeArray.length;
    }

    public int getColLength(){
        return mazeArray[0].length;
    }

    public String getMazeIndex(int row, int col){
        return mazeArray[row][col];
    }
}