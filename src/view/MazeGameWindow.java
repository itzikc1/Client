package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;




public class MazeGameWindow  extends BasicWindow{

	public MazeGameWindow(int width, int height, String title) {
		super(width, height, title);
	}

	@Override
	void initWidgets() {
		 shell.setLayout(new GridLayout(1, false));
		   Maze maze=new Maze(shell,SWT.BORDER);
		   maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true));
		   maze.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent e) {
					// TODO Auto-generated method stub
					
					
					
				}
			});

		   
	              
       }
     }
 		 



