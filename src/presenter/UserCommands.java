package presenter;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import networking.Client;
import model.Model;
import task.TaskRunnable;

public class UserCommands {
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	public UserCommands() {			
		commands.put("Select", new SelectDomainCommand());// key end value
		commands.put("Algorithm", new SelectAlgorithmCommand());
		commands.put("Solve", new SolveDomainCommand());
	}
	public interface Command {
		Model doCommand(Model model, String args);
	}
	public void doCommand(Model model, String commandName, String args) {
		Command command = commands.get(commandName);
		if (command != null) {
			command.doCommand(model, args);
		}
	}
	public Command selectCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}
	private class SelectDomainCommand implements Command// Create the problem
	{
		@Override
		public Model doCommand(Model model, String args) {
			model.selectDomain(args);
			return model;
		}
	}
	private class SelectAlgorithmCommand implements Command// select the															// algorithm
	{
		@Override
		public Model doCommand(Model model, String args) {
			model.selectAlgorithm(args);
			return model;
		}
	}
	private class SolveDomainCommand implements Command// show me the solve with use Thread
	{
		@Override
		public Model doCommand(Model model, String args) {
		model.solveDomain();
			return model;
		}
	}	
}
	