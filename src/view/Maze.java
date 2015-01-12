package view;


import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Maze extends Canvas{
	
	int row,col,wall;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getWall() {
		return wall;
	}
	public void setWall(int wall) {
		this.wall = wall;
	}
	int[][] mazeData={
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{0,0,0,0,0,0,0,0,1,1,0,1,0,0,1},
			{0,0,1,1,1,1,1,0,0,1,0,1,0,1,1},
			{1,1,1,0,0,0,1,0,1,1,0,1,0,0,1},
			{1,0,1,0,1,1,1,0,0,0,0,1,1,0,1},
			{1,1,0,0,0,1,0,0,1,1,1,1,0,0,1},
			{1,0,0,1,0,0,1,0,0,0,0,1,0,1,1},
			{1,0,1,1,0,1,1,0,1,1,0,0,0,1,1},
			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
};
	GameCharacter c;
	Timer timer;
	TimerTask task;

	public Maze(Composite parent, int style) {
        super(parent, style);
        //devise is the display like many scream
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
				Random r =new Random();
				c.x+=-5+r.nextInt(11);
				c.y+=-5+r.nextInt(11);
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