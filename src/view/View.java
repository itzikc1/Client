package view;
import model.*;

    public interface View  {   	
	public abstract String getUserAction();//get the string from the client
	public abstract void start();//start the view
	public abstract void displayCurrentState();//show me now what happens in game
	public abstract void displaySolution(Solution solution);//show show solution
	
}
	