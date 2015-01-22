package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import model.Problem;

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
//TODO start and stop 
public class EightPuzzle extends Canvas {
	Problem problem;
	int counter,number=0;
	ArrayList<model.Action> solution;
	public void setSolution(ArrayList<model.Action> arrayList) {
		this.solution = arrayList;
	}
	int[][] EightPuzzleData = {

	{ 1, 1, 1, 1, 1, 1, 1 },
	{ 1, 1, 0, 0, 0, 1, 1 },
	{ 1, 1, 0, 0, 0, 1, 1 },
	{ 1, 1, 0, 0, 0, 1, 1 },
	{ 1, 1, 1, 1, 1, 1, 1 },

	};
	ArrayList<Image> images = new ArrayList<Image>();
	
	//ArrayList<Image> images = new ArrayList<Image>();
	public EightPuzzle(Composite parent, int style,Problem problem) {
		super(parent, style);
		random(problem);
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				
				int num = 0;
				int width = getSize().x;
				int height = getSize().y;
				int w = width / EightPuzzleData[0].length;
				int h = height / EightPuzzleData.length;
				for (int i = 0; i < EightPuzzleData.length; i++) {
					for (int j = 0; j < EightPuzzleData[i].length; j++) {
						int x = j * w;
						int y = i * h;
						if (EightPuzzleData[i][j] == 0) {
							//images.add(new Image(Display.getDefault(),"resources/" + String.valueOf(num) + ".jpg"));	
							
							//e.gc.drawImage(pics.get(num), 0, 0, 95, 95, x, y,w, h);
							e.gc.drawImage(images.get(num), 0, 0, 95, 95, x, y,w, h);
							
							
							if (num != 8)
								num++;
							}
					}
				}                       
			}
		});
	}	
	public void moves(String string) {
		int win=0;	
		switch (string) {
		case "right": {		
			Image tamp = images.get(counter);
			images.set(counter, images.get(counter + 1));
			images.set(counter + 1, tamp);
			counter++;
            System.out.println(images.get(counter).handle);
            System.out.println(images.get(counter+1).handle);
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
			images.set(counter - 3, tamp);

			counter = counter - 3;

			redraw();
			break;
		}
		case "down": {

			Image tamp = images.get(counter);
			images.set(counter, images.get(counter + 3));
			images.set(counter + 3, tamp);
			counter = counter + 3;

			redraw();
			break;
		}
		
		}
		
		for (int i=1;i<8;i++){
			
			if(win==7)
				System.out.println("win");
			if ((images.get(i-1).hashCode()==i)){
				System.out.println("win");
				win++;
				
			}
			
			}
	
	}

	public void random(Problem problem) {
		
		this.problem=problem;
		String[] arr = problem.getDomainName().split("");
		//problem.getDomainName().valueOf(i);
		for (int i = 0; i < 9; i++) {	
		images.add(new Image(Display.getDefault(),"resources/" + arr[i] + ".jpg"));	
			
		}
		redraw();
	}
			
			
//		
//			ArrayList<Image> tamp = new ArrayList<Image>();
//		tamp.set(i, images.get(Integer.valueOf(arr[i])));
//		//Image tamp2=images.get(Integer.valueOf(i));
//		//images.set(i, images.get(Integer.valueOf(arr[i])));
//		
//		
//		images.set(Integer.valueOf(arr[i]),images.get(i));
//		images.set(i,tamp.get(1));
//				//"resources/" + Integer.valueOf(arr[i]) + ".jpg" );
//		
//		//Image tamp=new Image(Display.getDefault(), "resources/" + String.valueOf(arr[i]) + ".jpg");
////		images.set(i, images.get(n));
////		images.set(n, tamp);


//	Random rand = new Random();
//	for (int i = 1; i < 9; i++) {
//		int n = rand.nextInt(8)+1;
//		Image tamp = images.get(n);
//		images.set(n, images.get(i));
//		images.set(i, tamp);
//}
//	public boolean equals(Object object){
//		if(object instanceof Image && ((Image)object).getValue() == this.t){
//		    return true;
//		} else {
//		    return false;
//		}
//
}
