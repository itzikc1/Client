package view;

import model.*;

import java.util.Observable;
import java.util.Scanner;

import presenter.UserCommands;
public class MyConsoleView extends Observable implements View{
	
	private String userAction;
	private UserCommands command;
	@Override
	public void start() {
		//Welcome show
		System.out.println("Welcome to my project");
		System.out.println( "enter Select and after that the Game you want \"Maze\"or EightPuzzle and press enter.\n "+
		"enter Algorithm:to choose algorithm \n Enter Solve to start \n enter exit to quit any time you want to quit\n"+
		"thank you for choosing us project \n");	
		userAction = "";
	    Scanner scanner = new Scanner(System.in);  
			do
		{//for get anther command from user
			System.out.print("Enter command: ");
			userAction = scanner.nextLine();//get the command from user	
			if (!(userAction.equals("exit")))
			//{
				this.setChanged();
				this.notifyObservers();
			//}			
		} while (!(userAction.equals("exit")));	
			//exit all the thread
		//	command.shutdown();				
}
	@Override
	public String getUserAction() {
		return userAction;
	}
	@Override
	public void displayCurrentState() {
	}
	@Override
	public void displaySolution(Solution solution) {
		//show the Solution
		if(solution.getAction()==null)
		{
			System.out.print( "There is no way Path To Goal ");
			return ;
		}
		System.out.print( "There is a way Path To Goal :     ");
		for (Action a : solution.getAction())
		{	
			System.out.print( a.getActionName());
			System.out.print( " -> ");
		}	
		//print the time
		System.out.println("\n the time is:");
		System.out.println(solution.getTime());
	}
	@Override
	public void displayProblem(Problem problem) {
		// TODO Auto-generated method stub
		
	}
}