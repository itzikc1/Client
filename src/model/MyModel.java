package model;

import java.util.Observable;
import networking.Client;

public class MyModel extends Observable implements Model {
	private Problem problem=new Problem();
	private Solution solution;
	//select the specific problem
	@Override
	public void selectDomain(String domainName) {			
		this.problem.setDomainName(domainName);
	}
	//select the algorithm to solve the problem
	@Override
	public void selectAlgorithm(String algorithmName) {
		problem.setAlgorithm(algorithmName);
	}
	//to play algorithm
	@Override
	public void solveDomain() {	
		Client client = new Client();
		solution = client.getSolution(problem);	
		this.setChanged();
		this.notifyObservers();	
   }
	//get solution of the problem
	@Override
	public Solution getSolution() {	
		return solution;
	}
	@Override
	public void doTask() {
		solveDomain();
	}
}
