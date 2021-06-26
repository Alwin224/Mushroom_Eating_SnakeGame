/**this method makes the canvas and calls 
 * it to draw the canvas for the snake game itself 
 */
import java.awt.Color;

import javax.swing.JFrame;

public class Starter extends JFrame{
	Canvas theCanvas;

	public static final int WIDTH_OF_WINDOW = 600;
	public static final int HEIGHT_OF_WINDOW = 800;
	public Starter() {
		super();
		theCanvas = new Canvas();

		this.setSize(WIDTH_OF_WINDOW, HEIGHT_OF_WINDOW);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(theCanvas);
		this.setTitle("Snake Game");
	}	

	public static void main(String[] args) {
		Starter panel = new Starter();
		panel.setVisible(true);
		panel.setBackground(Color.black);
	}

}