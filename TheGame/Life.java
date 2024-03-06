package TheGame;

public abstract class Life {
    Cell cell;
    World world;
    int lastEaten;
    int turnsTaken;

    public Life(){
        // because world is instantiated so it is called twice
        this.world = new World();
        this.turnsTaken = 0;
    }
    // life knows Cell and world
    public Life(Cell cell, World world){
        this.cell = cell;
        this.world = world;
        this.turnsTaken = 0;
    }

//    public void check(){}
    public void move(){}
    public void action(){}

    public void reproduce(){}

    public void die(){}


    public void setCell(Cell cell){this.cell = cell;}

    public Cell getCell(){
        return cell;
    }

    public World getWorld(){
        return world;
    }


}
