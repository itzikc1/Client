package view;

import model.Solution;

public class MazeGameWindow extends BasicWindow implements View {
	private String userAction;
	
	public MazeGameWindow(int width, int height, String title) {
		super(width, height, title);
	}
	@Override
	public String getUserAction() {
		return userAction;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayCurrentState() {
		// TODO Auto-generated method stub
	}

	@Override
	public void displaySolution(Solution solution) {
		// TODO Auto-generated method stub
	}

	@Override
	void initWidgets() {
		// TODO Auto-generated method stub		
	}
}
