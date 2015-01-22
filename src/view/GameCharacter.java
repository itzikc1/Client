package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

	class GameCharacter{
		 int x,y;
		 Image image=new Image(Display.getDefault(),"resources/bart.png");
		public GameCharacter(int x,int y) {
		
			 this.x=x;this.y=y;
		   }
		   public void paint(PaintEvent e,int w,int h){
			e.gc.drawImage(image,0,0,256,256,x*w,y*h,w,h);
		   }
		}
