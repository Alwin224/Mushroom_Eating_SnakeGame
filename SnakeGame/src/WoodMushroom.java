import javax.swing.ImageIcon;
/*tells the Game Controller to tell the snake to 
 * set an Ignore Counter of 10 to ignore the user input until 
 * the user presses one arrow key 10 times
 */
public class WoodMushroom extends Mushroom{
	
	public WoodMushroom(int x, int y) {
		super(x,y);
		this.mushroomImage = new ImageIcon("Fungi/m2.png");
	}
	 /**this calls the ignore counter by delaying the users mushroom 
	  * implementing the decription above 
	  */
	@Override
	void whenConsumed(GameController gc) {
		this.snakeGame=gc;
		snakeGame.ka.setIgnoreCounter(10);
	}
}
