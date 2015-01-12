package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import presenter.UserCommands.Command;
import model.*;
import view.*;

public class Presenter implements Observer {
	private Model model;
	private View view;
	private UserCommands commands;
	private ArrayList<Model> models; // all running models
	
	//add now
	public Presenter(Model model) {
		this(model, null);
	}
	public void setView(View view) {
		this.view = view;
	}
	//
	public Presenter(Model model, View view) {
		this.model = model;
		this.view = view;
		commands = new UserCommands();
		models = new ArrayList<Model>();
		models.add(model);	
	}
	@Override
	public void update(Observable o, Object arg) {
		// go to model
		if (o instanceof Model) {
			Solution solution = model.getSolution();
			view.displaySolution(solution);
		}
		// go to view
		else if (o == view) {
			String action = view.getUserAction();// get the string from client
			String[] arr = action.split(" ");// split with the command with ""
			String commandName = arr[0];
			String args = null;
			if (arr.length ==5) {
				args = arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4];
		    }
			if (arr.length ==3){
				args = arr[1]+" "+arr[2];	
			}
			if (arr.length ==2){
				args = arr[1];	
			}
			Command command = commands.selectCommand(commandName);
			Model m = command.doCommand(model, args);
			// Check if we got a new model from the command
			if (m != model) {
				this.model = m;
				models.add(m);
				m.addObserver(this);
			}
		}
	}
	// //////////main/////////////////////////////
	public static void main(String[] args) {
		MyModel model = new MyModel();
		//Create the windows start
	    Presenter presenter = new Presenter(model);	
	    SelectGameWindow view = new SelectGameWindow(presenter,300, 300, "The Games");
		model.addObserver(presenter);
		view.run();
		//MyConsoleView view = new MyConsoleView();
		//Presenter presenter = new Presenter(model, view);
		//model.addObserver(presenter);
		//view.addObserver(presenter);
		//view.start();
	}
}
