package view;

import model.Solution;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;



public class MazeGameWindow1 extends UIView {
	String UserAction;
	String setselected;
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
		   Maze maze=new Maze(shell,SWT.MULTI | SWT.BORDER);
		   maze.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,8));
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
		// TODO Auto-generated method stub
		
	}


	
}
