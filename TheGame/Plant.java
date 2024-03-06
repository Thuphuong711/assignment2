package TheGame;

public class Plant extends Life implements HerbivoreFood{
    public Plant(){
        super();
    }
    public Plant(Cell cell, World world) {
        super(cell, world);
    }

    public void reproduce(){

    }
}
