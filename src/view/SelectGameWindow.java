package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

public class SelectGameWindow extends BasicWindow{
	public SelectGameWindow(int width, int height, String title) {
		super(width, height, title);		
	}
	@Override
	void initWidgets() {
	    shell.setLayout(new GridLayout(1, false));	
	    //Create the select button 
		final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
	    String items[] = { "EightPuzzle", "Maze" };
	    combo.setItems(items);
	    //////Create the start button  
	    Button btnSelectModel = new Button(shell, SWT.PUSH);
	    btnSelectModel.setText("Start");
	    btnSelectModel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
	    btnSelectModel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// Choose window according to the game 				
				display.dispose();
				if(arg0.text=="Maze")
				{
				BasicWindow window = new MazeGameWindow(400, 300, "Maze Game");
			    window.run();
				}
				else{
				BasicWindow window = new MazeGameWindow(400, 300, "Eight Puzzle Game");
			    window.run();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}