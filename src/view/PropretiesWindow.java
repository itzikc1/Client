package view;

import java.util.Observable;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import presenter.Presenter;

public abstract class PropretiesWindow extends Observable implements  Runnable{
	protected Shell shell;
	
	public PropretiesWindow(Presenter presenter, Display display, int width, int height,String title) {		
		shell=new Shell(display);
		shell.setSize(width, height);
		shell.setText(title);
		
		this.addObserver(presenter);
		//presenter.setView(this);
	}	
	abstract void initWidgets();
	
	public void run() {
		initWidgets();
		shell.open();	
		
		// Display the main shell when this shell is closed
		shell.addDisposeListener(new DisposeListener() {
			
			
			public void widgetDisposed(DisposeEvent arg0) {
				// TODO Auto-generated method stub
				Shell mainShell = shell.getDisplay().getShells()[0];
				mainShell.setVisible(true);
			}
		});	
	}
}
