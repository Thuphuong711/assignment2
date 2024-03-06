package TheGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI  extends JFrame implements MouseListener{
    Game game;
    JFrame frame;
    // later check panel = new JPanel() here
    JPanel panel = new JPanel();

    private int TileSize = 30;

    public GUI(){
        frame = new JFrame("Game of life");
        frame.setSize(750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setResizable(true);
        // this should be panel.addMouseListener(this); -> make this panel become white
        panel.addMouseListener(this);
    }

    public void displayWorld(final World world){
        System.out.println("Displaying the world");
        int rows= world.rows;
        int cols = world.cols;
        Cell[][] layout = world.getLayout();

        frame.setLayout(new GridLayout(rows, cols));
        for(int i = 0; i< layout.length; i++){
            for(int j = 0; j< layout[i].length; j++){
                panel = new JPanel();
                panel.setPreferredSize(new Dimension(TileSize,TileSize));
                Life occupant = layout[i][j].getOccupant();
                /**
                 * this code is to check whether that cell
                 * contains animal or plant to put the panel in
                 */
                if(occupant != null){
                    if(occupant instanceof Animal){
                        panel.setBackground(Color.YELLOW);
                    } else {
                        panel.setBackground(Color.GREEN);
                    }
                } else {
                    panel.setBackground(Color.WHITE);
                }
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                frame.add(panel);
            }
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void changeColor(Cell cell, String color){
        /**
        panel = new JPanel();
        Life occupant = cell.getOccupant();
        if(occupant instanceof Animal){
            panel.setBackground(Color.YELLOW);
        }
        else if(occupant instanceof Plant){
            panel.setBackground(Color.GREEN);
        }
        else{
            panel.setBackground(Color.WHITE);
        }
        */
        // check this again
        Cell[][] layout = game.getWorld().getLayout();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(TileSize,TileSize));
        int index_X = cell.getRows();
        int index_Y = cell.getCols();
        Cell currentCell =  layout[index_X][index_Y];

        /** how to get access directly to the panel
         * which is the currentCell
         * without looping through the layout
         */

        /**
         * for this code, it cannot get access directly
         * to the correct
         */
        for(int i =0; i < layout.length; i++){
            for(int j = 0; j < layout[i].length; j++){
                if(layout[i][j] == currentCell){
                    panel.setBackground(Color.getColor(color));
                    frame.add(panel);
                    /** how to get out of the nested loop soon
                     when the panel is added to the frame? */
                    break;
                }
            }
        }

    }

    public void setGame(Game game){

    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
