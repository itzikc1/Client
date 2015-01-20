package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

	class GameCharacter{
		 int x,y;
		 Image image=new Image(Display.getDefault(),"resources/matrixG.jpg");
		public GameCharacter(int x,int y) {
		
			 this.x=x;this.y=y;
		   }
		   public void paint(PaintEvent e,int w,int h){
			// Image image=new Image(Display.getDefault(),"resources/1.jpg");
			//e.gc.setForeground(new Color(null,255,0,0));
			//e.gc.drawOval(x*w,y*h,w,h);
			 //e.gc.drawImage(image, 0,0);
			e.gc.drawImage(image,0,0,225,225,x*w,y*h,w,h);
		   }
		}
