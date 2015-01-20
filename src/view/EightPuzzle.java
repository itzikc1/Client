package view;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class EightPuzzle extends Canvas {

	int counter=0;
	
	int[][] EightPuzzleData = {

	{ 1, 1, 1, 1, 1, 1, 1 },
	{ 1, 1, 0, 0, 0, 1, 1 },
	{ 1, 1, 0, 0, 0, 1, 1 },
	{ 1, 1, 0, 0, 0, 1, 1 },
	{ 1, 1, 1, 1, 1, 1, 1 },

	};
	
	ArrayList<Image> images=new ArrayList<Image>();
	
	
	public EightPuzzle(Composite parent, int style) {
		super(parent, style);
		
		//setBackground(new Color(null, 255, 255, 255));
		
		
		
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				
				int num = 0;
				
				
				//e.gc.setForeground(new Color(null, 50, 0, 0));
				//e.gc.setBackground(new Color(null, 50, 50, 0));
                
                
				
				int width = getSize().x;
				int height = getSize().y;
			
				int w = width / EightPuzzleData[0].length;
				int h = height / EightPuzzleData.length;
				
				
				for (int i = 0; i < EightPuzzleData.length; i++) {
					
					for (int j = 0; j < EightPuzzleData[i].length; j++) {

						int x = j * w;
						int y = i * h;
						
						
						if (EightPuzzleData[i][j] == 0) {
							
							images.add(new Image(Display.getDefault(),"resources/" + String.valueOf(num) + ".jpg"));
							
							e.gc.drawImage(images.get(num), 0, 0, 95, 95, x, y, w, h);
							
							if(num!=8)
							num++;
						}

					}

				}

			}
			
		});
	}

	
		
	public void start() {
		// TODO Auto-generated method stub

	}

	public void moves(String string) {
		// TODO Auto-generated method stubswitch(e){

		switch (string) {

		case "right": {
			Image tamp = images.get(counter);
			images.set(counter, images.get(counter + 1));
			images.set(counter + 1, tamp);

			counter++;

			redraw();
			break;
		}

		case "left": {

			Image tamp = images.get(counter);
			images.set(counter, images.get(counter - 1));
			images.set(counter - 1, tamp);

			counter--;

			redraw();
			break;
		}
		case "up": {

			Image tamp = images.get(counter);
			images.set(counter, images.get(counter - 3));
			images.set(counter- 3, tamp);

			counter = counter - 3;

			redraw();
			break;
		}
		case "down": {

			Image tamp = images.get(counter);
			images.set(counter, images.get(counter + 3));
			images.set(counter+ 3, tamp);
			counter = counter + 3;

			redraw();
			break;
		}
		}
	}
}