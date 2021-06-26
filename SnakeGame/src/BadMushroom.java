import javax.swing.ImageIcon;
/*This class tells the snake class to tell the
 * game controller to kill the snake
 */
public class BadMushroom extends Mushroom{
	public BadMushroom(int x, int y) {
		super(x,y);
		this.mushroomImage = new ImageIcon("Fungi/m4.png");
	}
	 /**this method calls the method from the game controller to kill 
	  * the snake 
	  */
	@Override
	void whenConsumed(GameController gc) {
		this.snakeGame=gc;
		snakeGame.killSnake();
	}
}
