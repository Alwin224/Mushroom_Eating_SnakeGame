import javax.swing.ImageIcon;
/**tells the game controller to tell the canvas to increase 
the speed which makes the update timer 5% less
*/
public class WildMushroom extends Mushroom{

	public WildMushroom(int x, int y) {
		super(x,y);
		this.mushroomImage = new ImageIcon("Fungi/m1.png");
	}
/**is called when mushroom interacts which leads to the update timer 5%less
 * 
 */
	@Override
	void whenConsumed(GameController gc) {
		this.snakeGame=gc;
		snakeGame.increaseUpdateSpeed();
	}
	
}
