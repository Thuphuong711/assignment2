package TheGame;

public class Animal extends Life{

    public Animal(){
        super();
    }

    public Animal(Cell cell, World world) {
        super(cell, world);
    }

    public void check(){}
    public void move(){}


    public void eat(Boolean check){}

    public void reproduce(){}

    public Cell getCell(){
        return cell;
    }

}
