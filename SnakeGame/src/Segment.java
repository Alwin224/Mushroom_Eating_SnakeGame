/*This class extends Rectangle and makes a new segment class
 * in which it prints it out and makes the segment 
 */
import java.awt.Rectangle;

public class Segment extends Rectangle{

	Segment next;

	public Segment(int iX, int iY, int iWidth, int iHeight) {
		this.x=iX;
		this.y=iX;
		this.width=iWidth;
		this.height=iHeight;
		next=null;
	}
/**this moves the segment by a certain x or y if the next segment
 * does not equal null
 * @param nx
 * @param ny
 */
	public void moveSegment(int nx, int ny) {
		if(next!=null) {
			next.moveSegment(this.x, this.y);
		}
		this.x=nx;
		this.y=ny;
	}


}
