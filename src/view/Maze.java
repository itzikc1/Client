package view;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.Problem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class Maze extends Canvas{
	Problem problem;
	boolean win=false;
	public Problem getProblem() {
		return problem;
	}
	ArrayList<model.Action> solution;
	int flag=0;
	int flag1=1;
	public void setSolution(ArrayList<model.Action> arrayList) {
		this.solution = arrayList;
	}
     int[][] mazeData;
//     ={
//			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
//			{0,0,0,0,0,0,0,0,1,1,0,1,0,0,1},
//			{0,0,1,1,1,1,1,0,0,1,0,1,0,1,1},
//			{1,1,1,0,0,0,1,0,1,1,0,1,0,0,1},
//			{1,0,1,0,1,1,1,0,0,0,0,1,1,0,1},
//			{1,1,0,0,0,1,0,0,1,1,1,1,0,0,1},
//			{1,0,0,1,0,0,1,0,0,0,0,1,0,1,1},
//			{1,0,1,1,0,1,1,0,1,1,0,0,0,1,1},
//			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,1},
//			{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
//};
	GameCharacter c;
	Timer timer;
	TimerTask task;
	//Image image=new Image(Display.getDefault(),"resources/Linux small.jpg");
	public Maze(Composite parent, int style,Problem problem) {
        super(parent, style);
        //devise is the display like many scream
       setProblem(problem);
       // setBackground(new Color(null, 255, 255, 255));
       
        c= new GameCharacter(0,0);
          addPaintListener(new PaintListener() {
    		@Override
    		public void paintControl(PaintEvent e) {
    			//e.gc.setForeground(new Color(null,0,0,0));
    			Image wall=new Image(Display.getDefault(),"resources/wall.jpg");
				//e.gc.setBackground(new Color(null,0,0,0));//black wall	
				   //create the size of the canvas
				   int width=getSize().x;
				   int height=getSize().y;
				   int w=width/mazeData[0].length;
				   int h=height/mazeData.length;				  
				   Image r=new Image(Display.getDefault(),"resources/goal.jpg");
				   for(int i=0;i<mazeData.length;i++){
				      for(int j=0;j<mazeData[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(mazeData[i][j]!=0){//black wall 
				         // e.gc.fillRectangle(x,y,w,h);
				        	 e.gc.drawImage(wall, 0, 0, 100,100, x, y, w, h);				       
				          }
				      }	
				   }
				   c.paint(e,w,h);
				   e.gc.drawImage(r,0,0,100,100,(mazeData.length-2)*w,(mazeData.length-1)*h,w,h);
 
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
						switch (solution.get(flag).getActionName()) {
						case "Left":
							if (mazeData[c.y][c.x-1]==0)
							{
							c.x=c.x-1;
							flag++;
							redraw();
							}
							if (mazeData[c.y][c.x-1]==0)
							{
								WinWindows();
							}
							break;
						case "Right":
							if (mazeData[c.y][c.x+1]==0)
							{
							c.x=c.x+1;
							flag++;
							redraw();
							}
							if (mazeData[c.y][c.x+1]==0)
							{
								WinWindows();
							}
							break;
						case "Down":
							if (mazeData[c.y+1][c.x]==0)
							{
							c.y=c.y+1;
							flag++;
							redraw();
							}
							if (mazeData[c.y+1][c.x]==0){
								WinWindows();
							}
							break;
						case "Up":
							if (mazeData[c.y-1][c.x]==0)
							{
							c.y=c.y-1;
							flag++;
							redraw();
							}
							if (mazeData[c.y-1][c.x]==0){
								WinWindows();
							}
							break;
						default:
							break;
						}
						redraw();
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
	public void setProblem(Problem problem) {
		this.problem = problem;	
		String[] arr = problem.getDomainName().split(" ");
		int [][] mazeData1=new int[Integer.parseInt(arr[7])+1][Integer.parseInt(arr[8])+1];	
		       for(int i=12;i<arr.length;i+=2)
		       {	    			
			   mazeData1[Integer.parseInt(arr[i])][Integer.parseInt(arr[i+1])]=1;	
		       }
		       for(int k=1;k<Integer.parseInt(arr[7]);k++)
		       {
		    	   mazeData1[Integer.parseInt(arr[7])][k]=1;  
	           }
		       for(int t=1;t<Integer.parseInt(arr[8]);t++)
		       {
		    	   mazeData1[t][Integer.parseInt(arr[8])]=1; 
	           }
               mazeData1[Integer.parseInt(arr[7])][Integer.parseInt(arr[8])]=1;
               //goal:
		       mazeData1[Integer.parseInt(arr[7])][Integer.parseInt(arr[8])-1]=2;
		       
		       
	   setMazeData(mazeData1);						
	}
	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}     
	public void startPlayer(String client){

		switch (client) {
		case "Left":	
			if (mazeData[c.y][c.x-1]==0)
			{
				c.x=c.x-1;
				redraw();
			}
			if (mazeData[c.y][c.x-1]==2)
			{
				this.win=true;
			}
			break;
		case "Right":
			if (mazeData[c.y][c.x+1]==0)
			{
			c.x=c.x+1;
			redraw();
			}		
			if (mazeData[c.y][c.x+1]==2)
			{
				this.win=true;
			}
			break;
		case "Down":
			if (mazeData[c.y+1][c.x]==0)
			{
				c.y=c.y+1;
				redraw();
			}	
			if (mazeData[c.y+1][c.x]==2)
			{
				this.win=true;
			}
			break;
		case "Up":
			if (mazeData[c.y-1][c.x]==0)
			{
			 c.y=c.y-1;
			 redraw();
			}	
			if (mazeData[c.y-1][c.x]==2)
			{
				this.win=true;
			}
			break;
		default:
			break;
		   }
		redraw();			
	}
	public boolean WinWindows()
	{
		
		return win; 
		
		
	}
		
}