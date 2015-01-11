package model;

import java.io.Serializable;
//tamir note//
public class Action implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//protected String string;
	protected String action; //name of Description action
	protected int actionPrice=1;
	public Action(String action )
	{	
		this.action=action;	
	}
	 public String getActionName() {		
			return action;
		}
	 public int getActionPrice() {
		return actionPrice;
	}
	public void setActionPrice(int actionPrice) {
		this.actionPrice = actionPrice;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getAction() {
		return actionPrice;
	}
}

	
