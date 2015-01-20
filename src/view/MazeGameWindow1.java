package view;


import model.Problem;
import model.Solution;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;


public class MazeGameWindow1 extends UIView {
	String UserAction;
	String setselected;
	Solution solution;
	Problem problem;
	public String getSetselected() {
		return setselected;
	}
	public void setSetselected(String setselected) {
		this.setselected = setselected;
	}
	public MazeGameWindow1(Presenter presenter,Display display,int width, int height, String title,String UserAction) {
		super(presenter,display,width, height, title);
		this.UserAction=UserAction;
	}
	@Override
	void initWidgets() {
		MazeGameWindow1.this.setChanged();
		MazeGameWindow1.this.notifyObservers();
		shell.setLayout(new GridLayout(2, false));		  
		   //fill all the windows 
		   Button start = new Button(shell, SWT.PUSH);
		   start.setText("Start");
		   start.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		   Image s=new Image(Display.getDefault(),"resources/blue.jpg");
		   Maze maze=new Maze(shell,SWT.MULTI | SWT.BORDER,problem);
		   maze.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,8));
		   maze.setBackgroundImage(s);		   
		   Button stop = new Button(shell, SWT.PUSH);
		   stop.setText("stop");
		   stop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		   Label lblAlgorithm = new Label(shell, SWT.NONE);
			lblAlgorithm.setText("Choose algorithm: ");
			final Combo combo = new Combo(shell, SWT.READ_ONLY);	
			combo.setLayoutData(new GridData(SWT.FILL, SWT.TOP,false, false,1,1));
		    String items[] = { "BFS", "A-star" };
		    combo.setItems(items);
		    Button solveserver = new Button(shell, SWT.PUSH);
		    solveserver.setText("solve with server");
		    solveserver.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		    ////////////////////////////////////////////////////////////////
		    Label toPlay = new Label(shell, SWT.NONE);
		    toPlay.setText("to play press and play: ");
		    Composite composite = new Composite(shell, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP,false, false,1,1));
			composite.setLayout(new GridLayout(2, false));
			Text text =new Text(composite, 0);
			text.addKeyListener(new org.eclipse.swt.events.KeyListener() {
				
				@Override
				public void keyReleased(org.eclipse.swt.events.KeyEvent arg0) {
					// TODO Auto-generated method stub4					
				}
				@Override
				public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
					System.out.println(e.keyCode);
					switch (e.keyCode){
					case 16777220:
					{
						maze.startPlayer("Right");
						System.out.println("Right");
						break;						
					}					
					case 16777219:
					{
						maze.startPlayer("Left");
						System.out.println("Left");
						break;
					}
					case 16777217:
					{
						maze.startPlayer("Up");
						System.out.println("Up");
						break;
					}
					case 16777218:
					{
						maze.startPlayer("Down");
						System.out.println("Down");
						break;
					}	
					}			
				}
			});		
            ///////////////////////////////////////////////////////////////	
			solveserver.addSelectionListener(new SelectionListener() {		
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					if(getSetselected()=="BFS")
					UserAction=null;
					UserAction="Algorithm bfs";
					MazeGameWindow1.this.setChanged();
					MazeGameWindow1.this.notifyObservers();
					if(getSetselected()=="A-star")
					{
						UserAction=null;
						UserAction="Algorithm a-star";
						MazeGameWindow1.this.setChanged();
						MazeGameWindow1.this.notifyObservers();
					}
					UserAction=null;
					UserAction="Solve";
					MazeGameWindow1.this.setChanged();
					MazeGameWindow1.this.notifyObservers();
					
				}			
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub					
				}
	        });
		    combo.addSelectionListener(new SelectionListener() {				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					setSetselected(combo.getText());					
				}				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub				
				}
			});
		    start.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.setSolution(solution.getAction());
				maze.start();	
			}		
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub				
			}
		});
		    stop.addSelectionListener(new SelectionListener() {			
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					maze.stop();	
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub					
				}
			});
	}
	@Override
	public String getUserAction() {
		return UserAction;
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
		this.solution=solution;	
	}
	@Override
	public void displayProblem(Problem problem) {
		this.problem=problem;	
	}
}
