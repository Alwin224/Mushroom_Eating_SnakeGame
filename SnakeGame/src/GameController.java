/**this class basically runs all of the classes in this project
 * 
 */
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class GameController {
	private Canvas theCanvas;

	protected int points;
	protected int lives;

	Snake ka;

	ArrayList<Mushroom> shrooms = new ArrayList<>();

	Random randy;
/**this constructor adds mushrooms to the array lists and makes a new snake 
 * and random handle to hold on to and draws it in the canvas
 * @param canvas
 */
	public GameController(Canvas canvas) {
		ka= new Snake(0, 0, 25,25);
		randy= new Random();
		this.theCanvas=canvas;
		shrooms.add(new WildMushroom(300,400));
		shrooms.add(new WoodMushroom(400,500));
		shrooms.add(new GoodMushroom(10,60));
		shrooms.add(new BadMushroom(60,70));
	}
	/**this method turns the snakes direction in the values that are shown 
	 * 0,1,2,3 which are values that are in the set direction function and also in the ignore 
	 * counter function, this then sets the direction of the snake 
	 * @param direction
	 */
	public void turnSnake(int direction) {
		if(direction==0) {
			ka.setDirection(-25, 0);
		}else if(direction==1) {
			ka.setDirection(25,0);
		}else if(direction==2) {
			ka.setDirection(0,25);
		}else if(direction==3) {
			ka.setDirection(0,-25);
		}
	}
	/**this updates the world by adding the method of the other classes 
	 * and moves the head of the snake and checks to see if the snake collides with the mushroom
	 * and checks to see if it is off world and if it is then it kills the snake
	 */
	public void updateWorld() {
		ka.moveHead();
		if(isSnakeOffWorld() || ka.isCollidingWithTail()) {
			killSnake();
		}
		checkMushroomCollision();
	
	}
/**this boolean function checks to see if the snake is off the world and if it is 
 * then it returns true
 * @return
 */
	public boolean isSnakeOffWorld() {
		if(ka.x>=600 || ka.y>=800 || ka.x<0 || ka.y<0) {
			return true;
		}else {
			return false;
		}
	}
	/**this checks that the lives are almost 0
	 * and if it is 0 and then that mean that it would return true if the lives are 0 
	 * @return
	 */
	public boolean isGameOver() {
		if(lives<=0) {
			return true;
		}else {
			return false;
		}
	}
	/**this function basically adds mushrooms to the 
	 * canvas by checking for the location and moving by the probability of its location
	 * good=70%,wild=15%, wood=10%, bad=5%
	 */
	public void tryToPlantMushroom() {
		int mushroomLocX = randy.nextInt(600);
		int mushroomLocY = randy.nextInt(800);
		double mushroomProb = randy.nextDouble();
		double mushroomSpawnProb = randy.nextDouble();
		if(mushroomSpawnProb<=.40) {
			if(mushroomProb<=.70) {
				shrooms.add(new GoodMushroom(mushroomLocX, mushroomLocY));
			}else if(mushroomProb<=.85) {
				shrooms.add(new WildMushroom(mushroomLocX, mushroomLocY));
			}else if(mushroomProb<=.95) {
				shrooms.add(new WoodMushroom(mushroomLocX, mushroomLocY));
			}else {
				shrooms.add(new BadMushroom(mushroomLocX, mushroomLocY));
			}
		}

	}
	/**this for loop iterates through all of the 
	 * mushroom array list and checks to see if it will intersect with the snake and if 
	 * it does then it intersects and ends up hitting a shroom and the snake collides and removes
	 * the mushrooms
	 */
	public void checkMushroomCollision() {
		Mushroom removed = null;
		for(Mushroom i: shrooms) {
//			System.out.print(i.x);
//			System.out.print(i.y);
			if(ka.intersects(i)) {
				i.whenConsumed(this);
				removed = i;
			}	
		}
		shrooms.remove(removed);
	}
	/**this sets delays the move about to where the 
	 * speed is increase because there is a delay of a certain
	 * percentage 
	 */
	public void increaseUpdateSpeed() {
		theCanvas.increaseSpeed();
	}
	/**this makes the snake grow by
	 * calling the class by the Snake method
	 */
	public void growSnake() {
		ka.grow();
	}
	/**this makes the snake die by setting the tail to null
	 * and the lives are lost and the points reset to 0
	 */
	public void killSnake() {
		ka.tailFirst=null;
		ka.tailLast=null;
		lives-=1;
		points=0;
	}
/**getters for the points, snake, and arraylist
 * @return
 */
	public int getPoints() {
		return points;
	}
	public int getLives() {
		return lives;
	}
	public ArrayList<Mushroom>getMushrooms() {
		return shrooms;
	}
	public Snake getSnake() {
		return ka;
	}
}
