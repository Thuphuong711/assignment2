package TheGame;

public class Cell {
    World world;
    Life occupant;
    int rows;
    int cols;

    //constructor for Cell to get
    // the number of rows and columns from the World class
    public Cell(int row, int cols, World world){
        this.rows = row;
        this.cols = cols;
        this.world = world;
    }

    // another constructor for Cell to get the World class
    public Cell(World world){
        this.rows = world.rows;
        this.cols = world.cols;

    }

    public void setOccupant(Life occupant){
        this.occupant = occupant;
    }

    //method for aggregating the Life class
    public Life getOccupant(){
        return occupant;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

}
