package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;

import presenter.Presenter;

public class SelectGameWindow extends BasicWindow{
	public class StringHolder{
		String setselected;
		
		public String getSetselected() {
			return setselected;
		}
		public void setSetselected(String setselected) {
			this.setselected = setselected;
		}
	}
	public SelectGameWindow(Presenter presenter,int width, int height, String title) {
		super(presenter,width, height, title);}

	@Override
	void initWidgets() {
		Image back=new Image(Display.getDefault(),"resources/background.jpg");
		shell.setBackgroundImage(back);
	    shell.setLayout(new GridLayout(2, false));	
	    //Create the select button 
	    final StringHolder message=new StringHolder(); 
	    message.setSetselected("not pressed");  
	    Button mazebutton = new Button(shell, SWT.PUSH);
	    Image maze=new Image(Display.getDefault(),"resources/maze.jpg");
	    mazebutton.setImage(maze);
	    Button eightpuzzleButton = new Button(shell, SWT.PUSH);
	    Image eightpuzzle=new Image(Display.getDefault(),"resources/eight puzzel.jpg");
	    eightpuzzleButton.setImage(eightpuzzle);
	    mazebutton.addSelectionListener(new SelectionListener() {	
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				message.setSetselected("Maze");	
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    eightpuzzleButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				message.setSetselected("EightPuzzle");	
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    //////Create the start button  
	    Button btnSelectModel = new Button(shell, SWT.PUSH);
	    Image start=new Image(Display.getDefault(),"resources/start.jpg");
	    btnSelectModel.setImage(start);
	    //btnSelectModel.setText("Start");
	    btnSelectModel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
	    btnSelectModel.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// Choose window according to the game 	  
				//display.dispose();	
				if(message.getSetselected().equals("Maze"))
				{
				PropretiesWindow mazepro =new PropretiesMaze(presenter, display, 400,300,"Maze Propreties");
				mazepro.run();
//				BasicWindow window = new MazeGameWindow(400, 300, "Maze Game");
//			    window.run();	
				}
				//if(message.eightpuzzleButton().equals("EightPuzzle"))
				//{
//				BasicWindow window = new MazeGameWindow(400, 300, "EightPuzzle");
//			    window.run();	
				//}		
			}	
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
				
	}
}
