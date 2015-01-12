package view;

import java.util.Observable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;

public class PropretiesMaze extends BasicWindow{
	private Presenter presenter;
	public PropretiesMaze(Presenter presenter,int width, int height, String title) {
		super(presenter,width, height, title);
		this.presenter=presenter;
		
	}
	private String userAction="Select maze"+" ";
	public void setUserAction(String userAction) {
		this.userAction += userAction;
	}
	@Override
	void initWidgets() {
		 shell.setLayout(new GridLayout(1, false));		  
		  //fill all the windows 
		  Button start = new Button(shell, SWT.PUSH);
		  start.setText("Start");
		  start.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		  Label lblRow = new Label(shell, SWT.NONE);
		  lblRow.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		  lblRow.setText("Enter row: ");
		  Text row=new Text(shell,SWT.MULTI | SWT.BORDER);
  	   row.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
  	   Label lblColl = new Label(shell, SWT.NONE);
  	   lblColl.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
  	   lblColl.setText("Enter coll: ");
		   Text col=new Text(shell,SWT.MULTI | SWT.BORDER);
  	   col.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
  	   Label lblwall = new Label(shell, SWT.NONE);
  	   lblwall.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
  	   lblwall.setText("Enter wall: ");
		   Text wall=new Text(shell,SWT.MULTI | SWT.BORDER);
  	   wall.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		   row.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {		
				userAction+= " "+row.getText();;
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		   
		   col.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				userAction+= " "+col.getText();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		   wall.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				userAction+= " "+wall.getText();	
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		    start.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				PropretiesMaze.this.setChanged();
				PropretiesMaze.this.notifyObservers();
				BasicWindow window = new MazeGameWindow(presenter,400, 300, "Maze Game");
			    window.run();	
					
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	public String getUserAction() {
		return userAction;
	}
	}
	

