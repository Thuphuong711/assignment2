package TheGame;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.turnWorld();

        System.out.println( game.getWorld().getLife(4,0).getClass().getName());
        Life life = game.getWorld().getLife(4,0);
        if(life instanceof Animal){
            Herbivore herbivore = new Herbivore(life.getCell(), life.getWorld());
            herbivore.move();
        }

        // should have a takeTurn method here
    }
}