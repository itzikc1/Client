package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import model.Action;
import model.SearchDomain;
import model.State;

public class MazeGameDomain implements SearchDomain{
	MazeGameState start,goal;
	public  MazeGameState [][] maze;
	private int row,coll;
	int numberOfWalls;
	//add to String the wall for the key in solution file
	public String wall1=" ";
	public String getWall1() {
		return wall1;
	}
	public  MazeGameDomain(int row , int coll, int numberOfWalls)
	{
		this.numberOfWalls=numberOfWalls;
		this.row=row;
		this.coll=coll;
		maze=new MazeGameState[row][coll];
		createRandomMaze();
		createWallMaze();	
		start=maze[0][0];	
		goal=maze[row-1][coll-1];
	 System.out.println("\n");
	}
	public void createRandomMaze()
	{
		for(int i=0 ; i<row ; i++)
		{
			for(int j=0 ; j<coll ; j++)
			{
				System.out.print("|");
				maze[i][j]= new MazeGameState(i, j,String.valueOf(1));             
			}	
			System.out.println("");	
			}
	}		
	 public State getStartState() {	
		return start;
	}
	@Override
	public State getGoalState() {
		
		return goal;
	}
	//Create the All Possible Moves
	@Override
	public HashMap<Action, State> getAllPossibleMoves(State current) {
		HashMap<Action,State> moves=new  HashMap<>();
MazeGameState a=(MazeGameState)current;
		Action left=new Action("Left");
		Action right=new Action("Right");
		Action down=new Action("Down");
		Action up=new Action("Up");	
		if(a.getWall() == false)
		{	
		if((a.stateY>0) && (maze[a.stateX ][a.stateY-1].getWall()==false))
		{
			moves.put(left, maze[a.stateX ][a.stateY-1]);	
		}
		if ((a.stateY < coll - 1) && (maze[a.stateX][a.stateY + 1].getWall()==false))
		{		
			moves.put(right, maze[a.stateX][a.stateY + 1]);
		}
		if ((a.stateX>0) && (maze[a.stateX-1 ][a.stateY ].getWall()==false))
		{
			moves.put(up, maze[a.stateX-1 ][a.stateY ]);
		}
		if ((a.stateX < row -1) && ( maze[a.stateX +1 ][a.stateY]).getWall()==false)
		{
			moves.put(down, maze[a.stateX +1 ][a.stateY]);		
		}
		}	
		return moves;
 }
	//create Wall Maze
	public void createWallMaze()
	{	
		Random rand= new Random();
		int arr[]= new int[numberOfWalls];
		
		for (int i=0; i<arr.length;i++){
		int  n = rand.nextInt(row-2);
		arr[i]=n;}		
		Arrays.sort(arr);	
		for (int i=0; i<arr.length;i++){
			int  n = rand.nextInt(coll-2);
			arr[i]=n;
			}		
		int num=0;
		for (int i=0; i<arr.length;i++){
		maze[arr[i]][num++].setWall(true);
		//add to string the wall for the key in solution file
		this.wall1+=String.valueOf(arr[i]);
		this.wall1+=" ";
		this.wall1+=String.valueOf(num++);
		this.wall1+=" ";
		}	
		////////////////////////////////
		for(int k=2;k<row;k++)
	       {
			maze[k][0].setWall(true);
			 this.wall1+=String.valueOf(k);			 
			 this.wall1+=" ";
			 this.wall1+=Integer.valueOf(0);
			 this.wall1+=" ";
	       }
			 for(int s=2;s<coll;s++)
	      
		       {
				 maze[0][s].setWall(true);
				 this.wall1+=Integer.valueOf(0);
				 this.wall1+=" ";			 
				 this.wall1+=String.valueOf(s);
				 this.wall1+=" ";
	       }
			 //////////////////////////////////////////
//			 this.wall1+=String.valueOf(this.row);
//			 this.wall1+=" ";
//			 this.wall1+=String.valueOf(k);	
//			 this.wall1+=" ";
//			 this.wall1+=String.valueOf(k);	
//			 this.wall1+=" ";
//			 this.wall1+=String.valueOf(this.row);
//			 this.wall1+=" ";
     
//		for(int s=0;s<row;s++)
//		{
//			
//			 maze[s][row].setWall(true);
//			 this.wall1+=String.valueOf(this.row);
//			 this.wall1+=" ";
//			 this.wall1+=String.valueOf(s);	
//			 this.wall1+=" ";
//			 maze[coll][s].setWall(true);
//			 this.wall1+=String.valueOf(this.coll);
//			 this.wall1+=" ";
//			 this.wall1+=String.valueOf(s);
//			 this.wall1+=" ";		
//		}
	}
	@Override
	public int GScore(State current) {
		MazeGameState a=(MazeGameState)current;
		if(a.stateX>start.stateX)
			a.setHprice(a.getHprice()+a.stateX-start.stateX);
	    else a.setHprice(a.getHprice()+start.stateX-a.stateX);
			
			if(a.stateY>start.stateY)
				a.setHprice(a.getHprice()+a.stateY-start.stateY);
			else a.setHprice(a.getHprice()+start.stateY-a.stateY);
			
			if(a.equals(start))
				return 0;
			
			return a.getGprice();	
	}
 
	@Override
	public int HScore(State current) {
		MazeGameState a=(MazeGameState)current;
		if(a.stateX>goal.stateX)
			a.setHprice(a.getHprice()+a.stateX-goal.stateX);
	    else a.setHprice(a.getHprice()+goal.stateX-a.stateX);
			if(a.stateY>goal.stateY)
				a.setHprice(a.getHprice()+a.stateY-goal.stateY);
			else a.setHprice(a.getHprice()+goal.stateY-a.stateY);
		if(a.equals(goal))
			return 0;		
					return a.getHprice();
	   }
	//Create the key for this specific maze 
	@Override
	public String getProblemDescription() {
	return "maze"+" "+"start State:" + " "+getStartState().stateToString() +" "+ ",final State:" +" "+ getGoalState().stateToString() +" "+ ",walls State:" +" "+ getWall1() ;
		
	}
}