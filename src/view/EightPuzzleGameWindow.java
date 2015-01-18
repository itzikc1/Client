package view;

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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
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
		String[] parts=new String[9];
	     parts = UserAction.split("-");
		
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
	    puzzle.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				
				e.gc.drawRectangle(100, 50, 40, 40);
				e.gc.drawRectangle(140, 50, 40, 40);
				e.gc.drawRectangle(180, 50, 40, 40);
				e.gc.drawRectangle(100, 90, 40, 40);
				e.gc.drawRectangle(140, 90, 40, 40);
				e.gc.drawRectangle(180, 90, 40, 40);
				e.gc.drawRectangle(100, 130, 40, 40);
				e.gc.drawRectangle(140, 130, 40, 40);
				e.gc.drawRectangle(180, 130, 40, 40);
				
				e.gc.drawString(parts[0], 110,55);
			}
		});
	    
	 ///// state for game
	    
	    
	    
	    
	    
	/// end (start)
	       
	       
	}
	} 


