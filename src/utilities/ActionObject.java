package utilities;

import interfaces.Action;

public class ActionObject {

	private Action action;
	private String gameObjectName;
	
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public String getGameObjectName() {
		return gameObjectName;
	}
	public void setGameObjectName(String gameObjectName) {
		this.gameObjectName = gameObjectName;
	}
	
}
