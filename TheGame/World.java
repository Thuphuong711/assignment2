package TheGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {
    int rows;
    int cols;
    Cell[][] layout;

    public World(){}

    public World(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.layout = new Cell[rows][cols];
    }

    public void createLife(){
        System.out.println("check");
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                layout[i][j] = new Cell(i,j,this);
                int random = RandomGenerator.nextNumber(100);
                if(random >= 85){
                    layout[i][j].setOccupant(new Animal(layout[i][j], this));
                } else if (random >= 65) {
                    layout[i][j].setOccupant(new Plant(layout[i][j], this));
                } else {
                    layout[i][j].setOccupant(null);
                }
            }
        }

    }

    /**
     * get the 8 Cell around a cell and put them in List
     * @param cell
     * @return
     */
    public List<Cell> getNeighbours(Cell cell){
        List<Cell> neighbours = new ArrayList<>();
        for(int i = cell.getRows()-1; i <= cell.getRows()+1; i++){
            for(int j = cell.getCols()-1; j<= cell.getCols()+1; j++){
                if(i >=0 && i<rows && j>=0 && j<cols && !( i == cell.getRows() && j == cell.getCols())){
                    neighbours.add(layout[i][j]);
                }
            }
        }

        //it works as expected
//        for(int i = 0; i<neighbours.size(); i++){
//            if(neighbours.get(i).getOccupant() != null)
//            System.out.println(neighbours.get(i).getOccupant().getClass().getName());
//            else{
//                System.out.println("null");
//            }
//        }
        return neighbours;
    }

    public Cell[][] getLayout(){
        return layout;
    }

    public World getWorld(){
        return this;
    }

    public Cell getCell(int row, int col){
        return layout[row][col];
    }

    public Life getLife(int row, int col){
        return layout[row][col].getOccupant();
    }
}
