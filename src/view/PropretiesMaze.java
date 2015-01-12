package view;




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

public class PropretiesMaze extends PropretiesWindow {
	private Presenter presenter;
	public PropretiesMaze(Presenter presenter, Display display, int width, int height,String title) {
		super(presenter,display, width, height, title);
		this.presenter=presenter;
	}
	private String userAction="Select maze";
	private String row;
	private String col;
	private String wall;
	public void setUserAction(String userAction) {
		this.userAction= userAction;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public String getWall() {
		return wall;
	}
	public void setWall(String wall) {
		this.wall = wall;
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
				setRow(row.getText());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		   
		   col.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setCol(col.getText());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		   wall.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setWall(wall.getText());	
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		    start.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//display.dispose();
				setRow(row.getText());
				setCol(col.getText());
				setWall(wall.getText());
				UIView window = new MazeGameWindow1(presenter,null,400, 300, "Maze Game",getUserAction());
			    window.run();	
					
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public String getUserAction() {
		return userAction + " "+getRow() + " " + getCol() + " " + getWall();
	 }

	
	}
	

