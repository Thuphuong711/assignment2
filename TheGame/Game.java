package TheGame;

import java.util.Scanner;

public class Game {
    int numTurns = 5;
    GUI gui;
    World world;
    int rows;
    int cols;

    public Game (){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number turn: ");
//        this.numTurns = sc.nextInt();

        gui = new GUI();
    }


    public void turnWorld(){
        Scanner sc = new Scanner(System.in);
        System.out.println("World created");
        System.out.println("Enter the number of rows: ");
        this.rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        this.cols = sc.nextInt();
        System.out.println("Turning the world");
        world = new World(rows, cols);
        world.createLife();
        gui.displayWorld(world);
    }

    public World getWorld() {
        return world;
    }
}
