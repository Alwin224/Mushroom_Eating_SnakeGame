/*This class draws the canvas 

 * and has special functions 
 * to move the head 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Canvas extends JPanel {
/**timers and set member variables 
 * 
 */
	private Timer animTimer;
	private Timer updateTimer;
	private Timer mushroomTimer;
	GameController game;

	private int x=-5;
	private int y=-5;
	private int dx;
	private int dy;

	public static final int SNAKE_WIDTH =50;
	public static final int SNAKE_HEIGHT = 50;
	public static final int SNAKE_X = 25;
	public static final int SNAKE_Y= 25;


	public Canvas() {

		super();
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.requestFocus();
/**these are the timers and all of the game controls
 * 
 */
		AnimationTimerHelper wario = new AnimationTimerHelper();
		animTimer = new Timer(1000 / 12, wario);
		UpdateTimerHelper daisy = new UpdateTimerHelper();
		updateTimer = new Timer(1000 / 9, daisy);
		MushroomTimerHelper mth = new MushroomTimerHelper();
		mushroomTimer = new Timer(1000 / 1, mth);
		game = new GameController(this);
		/**this method is the reason for why we 
		 * can move left down up right 
		 */
		KeyListener keyHelper= new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.turnSnake(0);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.turnSnake(1);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.turnSnake(2);
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					game.turnSnake(3);
				}
			}


			public void keyReleased(KeyEvent e) {
			}};

			this.addKeyListener(keyHelper);

			animTimer.start();
			updateTimer.start();
			mushroomTimer.start();
	}
	/**this method paints the snake head and checks to see for the current 
	 * which is designed as the tail first to make sure that it exists, while it exists it draws
	 * the next segment and draws the mushrooms
	 */
	public void paint(Graphics gfx) {
		if (x== -5) {
			x = this.getWidth()/2;
		}
		if (y == -5) {
			y = this.getHeight()/2;
		}
		super.paint(gfx);
		Snake head = game.getSnake();

		gfx.setColor(Color.green);
		gfx.drawRect(head.x, head.y, head.width, head.height);
		Segment current = head.tailFirst;
		while(current!=null) {
			gfx.drawRect(current.x, current.y, current.width, current.height);
			current=current.next;
		}
		for(Mushroom i : game.getMushrooms()) {
			gfx.drawImage(i.mushroomImage.getImage(), i.x, i.y, i.width, i.height , null);

		}
	}	

	public void onAnimationTimerTick() {
		Canvas.this.repaint();
	}
/**this method updates the world by calling the function from game controller
 * and changes the x and y by the direction
 */
	public void onUpdateTimerTick() {
		x = x+dx;
		y = y+dy;
		game.updateWorld();

	}
/**this calls a method from the game controller that plants mushrooms
 * 
 */
	public void onMushroomTimerTick() {
		game.tryToPlantMushroom();
	}
/**these methods are calling the timers and 
 * making sure that they work 
 * @author alwin
 *
 */
	private class AnimationTimerHelper implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			onAnimationTimerTick();
		}
	}

	private class UpdateTimerHelper implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			onUpdateTimerTick();

		}
	}

	private class MushroomTimerHelper implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			onMushroomTimerTick();

		}
	}
	/**makes the new delay 5% less than usual
	 * 
	 */
	public void increaseSpeed() {
	updateTimer.setDelay((int)Math.floor(updateTimer.getDelay()*0.95));
		}
	}



