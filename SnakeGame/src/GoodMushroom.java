import javax.swing.ImageIcon;
/*This tells the snake class to tell the game controller 
 * to grow the snake
 */
public class GoodMushroom extends Mushroom{
	public GoodMushroom(int x, int y) {
		super(x,y);
		this.mushroomImage = new ImageIcon("Fungi/m3.png");
	}
	 
	@Override
	void whenConsumed(GameController gc) {
		this.snakeGame=gc;
		snakeGame.growSnake();
	}
}
