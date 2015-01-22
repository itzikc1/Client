package view;

import model.Problem;
import model.Solution;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import presenter.Presenter;

public class EightPuzzleGameWindow extends UIView{

    Display display;
	String UserAction;
	String setselected;
	Solution solution;
	Problem problem;
	Presenter presenter;
	public String getSetselected() {
		return setselected;
	}
	public void setSetselected(String setselected) {
		this.setselected = setselected;
	}
	public EightPuzzleGameWindow(Presenter presenter, Display display,
			int width, int height, String title,String UserAction) {
		super(presenter, display, width, height, title);
		this.UserAction=UserAction;
		this.display=display;
	}

	@Override
	void initWidgets() {
		//to do	
		EightPuzzleGameWindow.this.setChanged();
		EightPuzzleGameWindow.this.notifyObservers();	
		shell.setLayout(new GridLayout(2, false));		
		///// new game
		EightPuzzle puzzle=new EightPuzzle(shell,SWT.MULTI | SWT.BORDER,problem);
		puzzle.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,8));
		
		Image a=new Image(Display.getDefault(), "resources/acs.jpg");
		puzzle.setBackgroundImage(a);
		//// start button
		Button start = new Button(shell, SWT.PUSH);
	    start.setText("Start");
	    start.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));

////////////////////////////////////////////////////////////////////////////////////////////	    
	    Button stop = new Button(shell, SWT.PUSH);
	    stop.setText("stop");
	    stop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
	    stop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				puzzle.stop();			
			}		
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub			
			}
		});	    
///////////////////////////////////////////////////////////////////////////////////////////////////////	       
	    puzzle.addKeyListener(new KeyListener() {		
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub			
			}		
			@Override
			public void keyPressed(KeyEvent e) {			
				switch(e.keyCode){			
				case SWT.ARROW_UP:{
					if(puzzle.start1!=0 && puzzle.start1!=1 && puzzle.start1!=2){
					puzzle.moves("up" );		
				}
					break;
			}			
				case SWT.ARROW_DOWN:{
					if(puzzle.start1!=6 && puzzle.start1!=7 && puzzle.start1!=8){
					puzzle.moves("down");
			        break;
			}
				}
				case SWT.ARROW_LEFT:{
					if(puzzle.start1!=0 && puzzle.start1!=3 && puzzle.start1!=6){
					puzzle.moves("left");			        
					}
					break;
			}		
				case SWT.ARROW_RIGHT:{
					if(puzzle.start1!=2 && puzzle.start1!=5 &&puzzle.start1!=8){
					puzzle.moves("right");				
					}
					break;
			}
		}			
	}
	});	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
	    Button random = new Button(shell, SWT.PUSH);
	    random.setText("random");
	    random.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
	    random.addSelectionListener(new SelectionListener() {
	    	boolean flag=false; 
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub		
			}
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(flag!=true){
				puzzle.random(problem);
				flag=true;
				}
				
			}
	    
	    });

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	    
	    Label lblAlgorithm = new Label(shell, SWT.NONE);
		lblAlgorithm.setText("Choose algorithm: ");
	    final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setLayoutData(new GridData(SWT.FILL, SWT.TOP,false, false,1,1));
	    String items[] = { "BFS", "A-star" };
	    combo.setItems(items);
	    Button solveserver = new Button(shell, SWT.PUSH);
	    solveserver.setText("solve with server");
	    solveserver.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
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
		solveserver.addSelectionListener(new SelectionListener() {		
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(getSetselected()=="BFS")
				UserAction=null;
				UserAction="Algorithm bfs";
				EightPuzzleGameWindow.this.setChanged();
				EightPuzzleGameWindow.this.notifyObservers();
				if(getSetselected()=="A-star")
				{
					UserAction=null;
					UserAction="Algorithm a-star";
					EightPuzzleGameWindow.this.setChanged();
					EightPuzzleGameWindow.this.notifyObservers();
				}
				UserAction=null;
				UserAction="Solve";
				EightPuzzleGameWindow.this.setChanged();
				EightPuzzleGameWindow.this.notifyObservers();
				
			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub					
			}
        });
	   
	    start.addSelectionListener(new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent arg0) {
			puzzle.setSolution(solution.getAction());
			puzzle.start();
		}		
		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub				
		}
	});
	       
	}
	

	@Override
	public void displayProblem(Problem problem) {
		this.problem=problem;	
	}
	@Override
	public String getUserAction() {
		// TODO Auto-generated method stub
		return this.UserAction;
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

}