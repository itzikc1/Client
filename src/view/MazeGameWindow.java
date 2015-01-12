package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;



public class MazeGameWindow  extends BasicWindow  {

	public MazeGameWindow(Presenter presenter,int width, int height, String title) {
		super(presenter,width, height, title);
	}

	@Override
	void initWidgets() {
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
				maze.setRow(Integer.parseInt(row.getText()));	
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		   
		   col.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.setCol(Integer.parseInt(col.getText()));
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		   wall.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.setWall(Integer.parseInt(col.getText()));
				
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
}
