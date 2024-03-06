package TheGame;


import java.awt.*;
import java.security.PrivateKey;
import java.util.List;

public class Herbivore extends Animal{
    private int turnWithoutFood;

    private final int numDie = 5;

    //for checking
    public Herbivore(){
        super();
//        Cell cell = super.getCell();
//        this.cell = new Cell(row, col, super.getWorld());
        turnWithoutFood = 0;

    }
    public Herbivore(Cell cell, World world){
        super( cell, world);
        turnWithoutFood = 0;
    }

    public Herbivore(Animal animal){
        super(animal.getCell(), animal.getWorld());
        turnWithoutFood = 0;
    }
    // this method is used to check the adjacent cells of the Herbivore object
    public void check(){
        System.out.println("Herbivore is checking");
        List<Cell> adjacentCells = super.getWorld().getNeighbours(super.getCell());

        //print the occupant of the adjacent cells to check whether this function works
        for(int i =0; i < adjacentCells.size(); i++){
            if(adjacentCells.get(i).getOccupant() != null)
            System.out.println(adjacentCells.get(i).getOccupant().getClass().getName());
            else {
                System.out.println("null");
            }
        }
    }

    public void move(){
        System.out.println("Herbivore is moving");
        // get the list of 8 adjacent cells of a cell
        List<Cell> adjacentCells = super.getWorld().getNeighbours(cell);

        // for each adjacent cell, check if it is empty or contains a plant
        for (Cell nearbycell : adjacentCells){
            Life occupant = nearbycell.getOccupant();
            if(occupant == null){
                // not really sure for this code.
                //I just want to make it randomly choose the cell to move to
                if(RandomGenerator.nextNumber(100) >=50){
                    cell.setOccupant(null);
                    nearbycell.setOccupant(this);
                    //update the new position
                    cell = nearbycell;
                    eat(false);
                } else {
                    continue;
                }
            } else if(occupant instanceof Plant){
                eat(true);
                cell.setOccupant(null);
                nearbycell.setOccupant(this);
                //make this nearbyCell become the new cell
                //which means that the Herbivore object has moved to a new cell
                cell = nearbycell;
            } else { // this is the case occupant instanceof Animal(Herbivore) in this case
                continue;
            }
            /**
             continue calls the for loop to move to the next
             nearby */

            //The break statement in this code is used to exit the loop
            // as soon as the Herbivore object has moved to a new cell
            GUI gui = new GUI();
            gui.changeColor(cell, "yellow");
            gui.changeColor(nearbycell, "white");
            break;


        }
    }

    @Override
    public void eat(Boolean check){
        // if check is true -> the herbivore eat plant -> reset turnWithoutFood = 0
        if(check){
            turnWithoutFood = 0;
        } else {
            // if check is false -> the herbivore does not eat plant
            // -> increment turnWithoutFood
            turnWithoutFood++;
        }
    }

    @Override
    public void die(){
        // if the Herbivore object has not eaten for 5 turns, it dies
        // need turnsWithoutFood variable to check == 5
        if(turnWithoutFood == numDie){
            cell.setOccupant(null);
        }
    }

    //haven't implemented yet
    @Override
    public void reproduce(){
//        System.out.println("Herbivore is reproducing");
    }
}
