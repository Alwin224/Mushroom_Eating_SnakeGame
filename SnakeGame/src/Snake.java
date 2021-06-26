/**This class extends rectangle and basically is the basis to the snake 
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake extends Rectangle{

	public Segment tailFirst;
	public Segment tailLast;
	public int dx;
	public int dy;


	protected int ignoreCounter;

	public Snake(int Ix, int Iy, int Iwidth, int Iheight) {
		super(Ix, Iy, Iwidth, Iheight);
		this.tailFirst=null;
		this.tailLast=null;
	}
	/**this method sets the direction of the snake itself and
	 * either turns it right or left 
	 * @param dx
	 * @param dy
	 */

	public void setDirection(int dx, int dy) {

		if(ignoreCounter==0) {
			this.dx=dx;
			this.dy=dy;
		}else {
			ignoreCounter-=1;
		}
	}
	/**this method moves the head by changing the direction and adding to it 
	 * 
	 */
	public void moveHead() {
		moveSegments();
		x+=dx;
		y+=dy;
	}
	/**moved the segment by check if the first tail was not null,
	 * since it is not it will move the segment by an x and y value
	 */
	private void moveSegments() {
		if(tailFirst!=null) {
			tailFirst.moveSegment(x,y);
		}
	}
	/**this takes the current segment which is named as the tailfirst 
	 * then checks to see if that segment exists then sees if that tailfirst segment 
	 * intersects the head
	 * which returns as true then sets the current segment equal to the next 
	 * @return
	 */
	public boolean isCollidingWithTail() {
		boolean hit = false;
		Segment current = tailFirst;
		while(current!=null) {
			if(current.intersects(this)) {
				hit = true;
			}
			current = current.next;
		}
		return hit;
	}
	/**sets the snakes ignore counter and makes the user
	 * have a restriction on counters
	 */
	public void setIgnoreCounter(int i) {
		this.ignoreCounter=i;
	}
	/**The grow function adds a segment that is a rectangle to the the head of the snake and then sets the head as the tail
	 * and the else function if their is a head sets the tails next as the first segment when collision
	 * and sets the last as the next. This is an example of a linked list.
	 */
	public void grow() {
		if(tailFirst==null) {
			Segment segment = new Segment(x, y, width, height);
			tailFirst=segment;
			tailLast=tailFirst;

		}else {
			Segment segment2 = new Segment(x,y,width,height);
			tailLast.next = segment2;
			tailLast = tailLast.next;
		}
	}


}

//public void drawSnake(Graphics g) {
//g.setColor(Color.green);
//g.drawRect(x, y, width, height);
//Segment tail = tailFirst.next;
//do{
//	g.drawRect(tail.x, tail.y, tail.width, tail.height);
//	if(tail.next!=null) {
//		tail=tail.next;
//	}
//}while(tail.next!=null);
//}
//new Segment 
//segment make the end of the snake its next equal to new segment 
//make the new segment, it needs an x and y of the constructor so make it the width and height
//make last segment point to new segment 
//add the segments together