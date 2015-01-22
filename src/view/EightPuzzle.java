package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.Problem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
	int flag=0;
	int start1=0;
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
	Timer timer;
	TimerTask task;
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
							e.gc.drawImage(images.get(num), 0, 0, 95, 95, x, y,w, h);
							if (num != 8)
								num++;
							}
					}
				}                       
			}
		});
        addDisposeListener(new DisposeListener() {		
			@Override
			public void widgetDisposed(DisposeEvent arg0) {
			stop();		
			}
		});
	}
		public void start(){
             flag=0;
			timer= new Timer();
			task=new TimerTask() {
				@Override
				public void run() {
					getDisplay().syncExec(new Runnable() {
						@Override
						public void run() {
							if(solution.size()==flag)
							{
								
								for (int i = 0; i < 9; i++) {
									Image tamp =new Image(Display.getDefault(),"resources/" + String.valueOf(i) + ".jpg");
								images.set(i,tamp);
								redraw();
								stop();
								}
							}
							else{
							String[] arr = solution.get(flag).getActionName().split("");	
							for (int i = 0; i < 9; i++) {	
								Image tamp = images.get(i);
								images.set(i,images.get(Integer.parseInt(arr[i])));
								images.set(Integer.parseInt(arr[i]),tamp);
							}
							flag++;
							redraw();
						}
										
						}
					});			
				}
			};
			  timer.scheduleAtFixedRate(task, 0,250);
		   }
		public void stop(){
			if(task!=null)
			task.cancel();
			if(timer!=null)
			timer.cancel();
		}

	public void moves(String string) {
		int win=0;	
		switch (string) {
		case "right": {		
			Image tamp = images.get(start1);
			images.set(start1, images.get(start1 + 1));
			images.set(start1 + 1, tamp);
			start1++;
           
            redraw();
			break;
		}
		case "left": {

			Image tamp = images.get(start1);
			images.set(start1, images.get(start1 - 1));
			images.set(start1 - 1, tamp);

			start1--;

			redraw();
			break;
		}
		case "up": {

			Image tamp = images.get(start1);
			images.set(start1, images.get(start1 - 3));
			images.set(start1 - 3, tamp);

			start1 = start1 - 3;

			redraw();
			break;
		}
		case "down": {

			Image tamp = images.get(start1);
			images.set(start1, images.get(start1 + 3));
			images.set(start1 + 3, tamp);
			start1 = start1 + 3;

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
		String[] arr = problem.getDomainName().split(" ");
		String[] arr1 = arr[1].split("");
		for (int i = 0; i < 9; i++) {	
			if(arr1[i].equals("0"))
			{
				this.start1+= i;
			}
	images.add(new Image(Display.getDefault(),"resources/" + arr1[i]+ ".jpg"));	
			
		}
		redraw();
	}

}
