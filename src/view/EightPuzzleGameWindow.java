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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import presenter.Presenter;

public class EightPuzzleGameWindow extends UIView{

	String UserAction;
	String selected;
	Solution solution;
	Display display;
	
	
	
	public EightPuzzleGameWindow(Presenter presenter, Display display,
			int width, int height, String title,String UserAction) {
		super(presenter, display, width, height, title);
		this.UserAction=UserAction;
		this.display=display;
		
	   
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	void initWidgets() {
		//to do
		
//		EightPuzzleGameWindow.this.setChanged();
//		EightPuzzleGameWindow.this.notifyObservers();
		
		
		
		shell.setLayout(new GridLayout(2, false));		
		///// new game
		EightPuzzle puzzle=new EightPuzzle(shell,SWT.MULTI | SWT.BORDER);
		puzzle.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,8));
		
		Image a=new Image(Display.getDefault(), "resources/acs.jpg");
		puzzle.setBackgroundImage(a);
		   
		
		
		//// start button
		Button start = new Button(shell, SWT.PUSH);
	    start.setText("Start");
	    start.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
	    
	    start.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//puzzle.setSolution(solution.getAction());
				puzzle.start();	
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		
	} );
////////////////////////////////////////////////////////////////////////////////////////////	    
	    Button stop = new Button(shell, SWT.PUSH);
	    stop.setText("stop");
	    stop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
	    stop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
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
					if(puzzle.counter!=0 || puzzle.counter!=1 || puzzle.counter!=2){
					puzzle.moves("up" );
					
					
					
				}
					break;
				}
				
				case SWT.ARROW_DOWN:{
					if(puzzle.counter!=6 || puzzle.counter!=7 || puzzle.counter!=8){
					puzzle.moves("down");
			        break;
			}
				}
				case SWT.ARROW_LEFT:{
					if(puzzle.counter!=2 || puzzle.counter!=5 || puzzle.counter!=8){
					puzzle.moves("left");
			        
					}
					break;
			}
				
				case SWT.ARROW_RIGHT:{
					if(puzzle.counter!=0 || puzzle.counter!=3 ||puzzle.counter!=6){
					puzzle.moves("right");
					
					}
					break;
			}
		}
			
		}
			
		
	   

	});	



	    
	
	    
	    
	    
	    
	    
	/// end (start)
	       
	}

	@Override
	public void displayProblem(Problem problem) {
		// TODO Auto-generated method stub
		
	}
}