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

public class EightPuzzleProprties extends PropretiesWindow{
	private Presenter presenter;
	public EightPuzzleProprties(Presenter presenter, Display display,int width, int height, String title) {
		super(presenter, display, width, height, title);
		this.presenter=presenter;
	}
	private String userAction="Select EightPuzzle";
	private String choice;
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	private String userChoice;
	public String getUserChoice() {
		return userChoice;
	}	
	public void setUserChoice(String userChoice) {
		this.userChoice= userChoice;
	}
	
	@Override
	void initWidgets() {
		 shell.setLayout(new GridLayout(1, false));			 
		 Button start = new Button(shell, SWT.PUSH);
		  start.setText("Start");
		  start.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		  Label order = new Label(shell, SWT.NONE);
		  order.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		  order.setText("Enter your order: ");
		  Text text=new Text(shell,SWT.MULTI | SWT.BORDER);
		  text.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		  Button choose = new Button(shell, SWT.RADIO);
		  choose.setText("Random Order");	  
//////////////////////////////////////////////////////////////////////
		  choose.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//setUserChoice(null);				
			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub			
			}
		});
		  text.addSelectionListener(new SelectionListener() {			
				@Override
				public void widgetSelected(SelectionEvent arg0) {		
					setChoice(text.getText());
				}			
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub					
				}
			});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////		  
		
		  start.addSelectionListener(new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent arg0) {
			setUserChoice(text.getText());
			//display.dispose();		
			UIView window = new EightPuzzleGameWindow(presenter,null,750, 500, "Eight Puzzle Game",getUserAction());
		    window.run();			
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	}

	protected String getUserAction() {
	 return userAction+" "+getUserChoice();
	}
	}
