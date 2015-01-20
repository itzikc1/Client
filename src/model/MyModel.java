package model;

import java.util.Observable;

import networking.Client;

public class MyModel extends Observable implements Model {
	private Problem problem=new Problem();
	
	private Solution solution;
	 private SearchDomain domain;
	//select the specific problem
	@Override
	public void selectDomain(String domainName) {			
		DomainFactory domainFactory=new DomainFactory();
		this.problem.setDomainName(domainFactory.getDomain(domainName));
		this.setChanged();
		this.notifyObservers();	
		
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
	@Override
	public Problem getProblem() {
		return this.problem;
	}
	
}
