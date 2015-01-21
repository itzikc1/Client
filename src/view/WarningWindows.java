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

public class WarningWindows extends UIView{

	public WarningWindows(Presenter presenter, Display display, int width,
			int height, String title) {
		super(presenter, display, width, height, title);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void initWidgets() {
		 shell.setLayout(new GridLayout(1, false));
		
		   Label lblwall = new Label(shell, SWT.NONE);
	  	   lblwall.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,1,1));
	  	   lblwall.setText("you entered too much wall please try again");
	  	   Button ok = new Button(shell, SWT.PUSH);
	  	   ok.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
	  	   ok.setText("OK");
		   ok.addSelectionListener(new SelectionListener() {	
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					shell.close();	
				}				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {	
				}
			});
		
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

	
}
