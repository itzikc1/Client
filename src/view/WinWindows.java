package view;

import model.Problem;
import model.Solution;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;
public class WinWindows extends UIView {

	public WinWindows(Presenter presenter, Display display, int width,
			int height, String title) {
		super(presenter, display, width, height, title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUserAction() {
		// TODO Auto-generated method stub
		return null;
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
	public void displayProblem(Problem problem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void initWidgets() {
		//Image t=new Image(Display.getDefault(),"resources/win.jpg");
		 //shell.setBackgroundImage(t);
		 shell.setLayout(new GridLayout(1, false));
		  Button mazebutton = new Button(shell, SWT.PUSH);
		  Image maze=new Image(Display.getDefault(),"resources/win.jpg");
		  mazebutton.setImage(maze);
		  mazebutton.addSelectionListener(new SelectionListener() {	
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					shell.close();	
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	}

	
			


}