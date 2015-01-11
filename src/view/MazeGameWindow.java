package view;

import org.eclipse.swt.layout.GridLayout;

import model.Solution;

public class MazeGameWindow extends BasicWindow implements View {
	private String userAction;
	
	public MazeGameWindow(int width, int height, String title) {
		super(width, height, title);
	}
	@Override
	public String getUserAction() {
		return userAction;
	}

	@Override
	public void start() {
		run();
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
	void initWidgets() {
		
//		shell.setLayout(new GridLayout(2, false));
//		
//		Label lblStartWord = new Label(shell, SWT.NONE);
//		lblStartWord.setText("Enter start word: ");
//		
//		final Text txtStartWord = new Text(shell, SWT.BORDER);
//		txtStartWord.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//		
//		Label lblEndWord = new Label(shell, SWT.NONE);
//		lblEndWord.setText("Enter end word: ");
//		
//		final Text txtEndWord = new Text(shell, SWT.BORDER);
//		txtEndWord.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//		
//		Label lblAlgorithm = new Label(shell, SWT.NONE);
//		lblAlgorithm.setText("Choose algorithm: ");
//		
//		final Combo combo = new Combo(shell, SWT.READ_ONLY);	
//		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
//	    String items[] = { "BFS", "A-Star" };
//	    combo.setItems(items);
//		
//		Button btnSearch = new Button(shell, SWT.PUSH);
//		btnSearch.setText("Search");
//		btnSearch.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
//		
//		lstActions = new List(shell, SWT.BORDER | SWT.V_SCROLL);
//		lstActions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
//				
//		btnSearch.addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent arg0) {	
//				userAction = "SelectDomain WordGameDomain:" + txtStartWord.getText() +
//						"," + txtEndWord.getText();		
//				WordGameWindow.this.setChanged();
//				WordGameWindow.this.notifyObservers();	
//				
//				userAction = "SelectAlgorithm " + combo.getText();
//				WordGameWindow.this.setChanged();
//				WordGameWindow.this.notifyObservers();	
//				
//				userAction = "SolveDomainInThread";
//				WordGameWindow.this.setChanged();
//				WordGameWindow.this.notifyObservers();	
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//								
//			}
//		});
	}
}
