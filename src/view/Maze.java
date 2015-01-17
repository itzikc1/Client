package view;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import model.Problem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Maze extends Canvas{
	Problem problem;
	
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
	public Maze(Composite parent, int style,Problem problem) {
        super(parent, style);
        //devise is the display like many scream
        setProblem(problem);
        setBackground(new Color(null, 255, 255, 255));
        ////////////////////TODO
        c= new GameCharacter(getSize().x,getSize().y);
        /////////////////////////////
          addPaintListener(new PaintListener() {
    		@Override
    		public void paintControl(PaintEvent e) {
    			e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));
				   int width=getSize().x;
				   int height=getSize().y;
				   int w=width/mazeData[0].length;
				   int h=height/mazeData.length;
				   //the r defined the minimum for size the maze 
                   // int r =Math.min(w,h);
				   for(int i=0;i<mazeData.length;i++)
				      for(int j=0;j<mazeData[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(mazeData[i][j]!=0)//black wall 
				            e.gc.fillRectangle(x,y,w,h);
				          //e.gc.fillRectangle(x,y,r,r);
				      }	
				  
				   c.paint(e, w,h);
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
							c.x=c.x-flag1;
							flag++;
							break;
						case "Right":
							c.x=c.x+flag1;
							flag++;
							break;
						case "Down":
							c.y=c.y+flag1;
							flag++;
							break;
						case "Up":
							c.y=c.y-flag1;
							flag++;
							break;
						default:
							break;
						}
						redraw();
					}
				});			
			}
		};
		  timer.scheduleAtFixedRate(task, 0,100);
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
		       for(int i=12;i<arr.length-1;i++)
		       {	    			
			    mazeData1[Integer.parseInt(arr[i])][Integer.parseInt(arr[i+1])]=1;		
		       }
		       for(int k=0;k<Integer.parseInt(arr[7]);k++)
		       {
		    	   mazeData1[k][0]=1;
		    	   mazeData1[0][k]=1; 
		    	   mazeData1[Integer.parseInt(arr[7])][k]=1; 
		    	   mazeData1[k][Integer.parseInt(arr[7])]=1; 	   
		       }
		       mazeData1[0][1]=0; 
		       mazeData1[Integer.parseInt(arr[7])][Integer.parseInt(arr[8])]=1;
		       mazeData1[Integer.parseInt(arr[7])][Integer.parseInt(arr[8])-1]=0;	       
	   setMazeData(mazeData1);						
	}
	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}     
	public void startPlayer(String client){
		switch (client) {
		case "Left":
				
			if (mazeData[c.x-1][c.y]!=0)
			{
			c.x=c.x;
			}
			else{ c.x=c.x-1;	}			
			break;
		case "Right":
			if (mazeData[c.x+1][c.y]!=0)
			{
			c.x=c.x;
			}
			else {c.x=c.x+1;}		
			break;
		case "Down":
			if (mazeData[c.x][c.y+1]!=0)
			{
			c.x=c.x;
			}
			else {c.y=c.y+1;	}	
			break;
		case "Up":
			if (mazeData[c.x][c.y-1]!=0)
			{
				c.y=c.y;
			}
			else{ c.y=c.y-1;}	
			break;
		default:
			break;
		}
		redraw();	
		
	}
		
	
}