import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMover implements MouseMotionListener {
   private static final int MOVE_AFTER_IDLE_TIME = 5000;
   
   private static long mouseLastMoved = System.currentTimeMillis();
   private static int pixelsToMove = 10;
   
   @Override
   public void mouseDragged(MouseEvent e) {
	   
   }
   
   @Override 
   public void mouseMoved(MouseEvent e) {
	   System.out.println("mouse moved");
	   mouseLastMoved = System.currentTimeMillis();
   }
   
   public static void main(String[] args) throws Exception {
	   Robot robot = new Robot();
	   while (true) {
		   if (System.currentTimeMillis() - mouseLastMoved > MOVE_AFTER_IDLE_TIME) {
			   Point point = MouseInfo.getPointerInfo().getLocation();
			   int x = point.x;
			   int y = point.y;
			   robot.mouseMove((x + pixelsToMove), y);
			   pixelsToMove = pixelsToMove * -1;
			   mouseLastMoved = System.currentTimeMillis();
		   }
	   }
    }
}