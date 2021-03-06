package hardestgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 *
 * @author John Word
 */
public class Player {
    private int x, y;
    //constants
    private final static int WIDTH = 50, HEIGHT = 50, SPEED = 4;
    private final static Color COLOR = Color.RED;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //1. draw outline on shape
    public void draw(Graphics g) {        
        g.setColor(COLOR);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, WIDTH, HEIGHT);
    }
    
    //7. implement method playerVsEnemy
    /**
     * Checks if player collides with an enemy
     * and respawns player if it does
     * @param enemy the enemy to check for collision against
     * @param start the player respawns in middle of start if collides with enemy
     */
    public void playerVsEnemy(Enemy enemy, Goal start) {

    }

    //8.a. implement method isInBounds
    /**
     * Determines if player is still in bounds
     * @param border boundaries of the room
     * @return isInBounds Whether the player is in bounds or not
     */
     public boolean isInBounds(Border border) {
         
            Rectangle playerBounds = new Rectangle(x, y, WIDTH, HEIGHT);
            Rectangle borderBounds = new Rectangle(border.getX(), border.getY(), border.getWidth(), border.getHeight());
            if (!borderBounds.contains(playerBounds)) {
                return false;
            }
            else {
                return true;
            }      
        }
     public void boundChecker(Border border) {
         if (isInBounds(border) == false) {
           x = 50;
           y = 300;
         }
     }
    //9. implement method playerVsGoal
    /**
     * Determines if player reaches a goal
     * @param finish goal player might have reached
     * @return didReachGoal Whether the player reached the goal or not
     */
     public boolean playerVsGoal(Goal finish) {
         Rectangle playerBounds = new Rectangle(x,y, WIDTH, HEIGHT);
         Rectangle goalBounds = new Rectangle(finish.getX(), finish.getY(), finish.getWidth(), finish.getHeight());
         if (playerBounds.intersects(goalBounds)) {
             return true;
         }
         else {
             return false;
         }
     }
     public void winStatement(Goal goal) {
         if (playerVsGoal(goal) == true) { 
             System.out.println("You Are Win");
             System.exit(0);
         }
     }
      /**
     * Moves player as long as still in bounds
     * @param dx Change in x direction: -1, 0, or 1
     * @param dy Change in y direction: -1, 0, or 1
     * @param border Boundaries of room to ensure player is inbounds
     */
    public void move(int dx, int dy, Border border) {
    //8.b. player can only move if still in bounds
        x += dx * SPEED;
        y += dy * SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }    
}