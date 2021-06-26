import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Mushroom extends Rectangle{

	ImageIcon mushroomImage;
	GameController snakeGame;

	public Mushroom(int x, int y) {
		super(x,y, 25,25);


	}
	abstract void whenConsumed(GameController gc);

}
