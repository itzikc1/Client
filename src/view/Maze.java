package view;

import game.MazeGameState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
      c= new GameCharacter(10,10);
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
				          if(mazeData[i][j]!=0)
				            e.gc.fillRectangle(x,y,w,h);
				          //e.gc.fillRectangle(x,y,r,r);
				      }	
				   c.paint(e, w, h);
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
		timer= new Timer();
		task=new TimerTask() {
			@Override
			public void run() {
				getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						if(solution.isEmpty())
						{
						stop();
						}
						flag++;	
						if(solution.get(flag).getActionName()=="Left")
						{
							c.x=c.x-1;
							c.y=c.y;
						}
						if(solution.get(flag).getActionName()=="Right")
						{	
							c.x=c.x+1;
							c.y=c.y;
						}
						if(solution.get(flag).getActionName()=="Down")
						{
							
							c.x=c.x;
							c.y=+1;
						}
						if(solution.get(flag).getActionName()=="Up")
						{							
							c.x=c.x;
							c.y=-1;
						}
						solution.remove(flag);
						redraw();
					}
				});			
			}
		};
		  timer.scheduleAtFixedRate(task, 0, 500);
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
		int [][] mazeData1=new int[Integer.parseInt(arr[6])+1][Integer.parseInt(arr[7])+1];	
		       for(int k=11;k<arr.length-1;k++)
		       {	    			
			    mazeData1[Integer.parseInt(arr[k])][Integer.parseInt(arr[k+1])]=1;		
		       }
	   setMazeData(mazeData1);						
	}
	public void mazeStart(int row,int col,int wall){
		
		int row1=row;
		int col1=col;	
	    int [][] maze=new int [row1][col1];
        for( int i=0;i<row;i++)
        {
        	for( int j=0;i<col;j++)
            {
            	maze[i][j]=0;	
            }           	
        }
	    //createWallMaze(wall1);	
	    Random rand= new Random();
		int arr[]= new int[wall];	
		for (int i=0; i<arr.length;i++){
		int  n = rand.nextInt(col1);
		arr[i]=n;}		
		Arrays.sort(arr);	
		for (int i=0; i<arr.length;i++){
			int  n = rand.nextInt(col1);
			arr[i]=n;}
		int num=0;
		for (int i=0; i<arr.length;i++){
		maze[arr[i]][num++]=1;
		}		
        setMazeData(maze);
	  }
	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
	}     

}