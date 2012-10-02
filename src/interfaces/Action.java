package interfaces;

import utilities.Actions;
import game.GameObject;

public interface Action {
	public void act(GameObject gameObject);
	public Actions getActionType();
	public void setAgainstObjectName(String againstObjectName);
	public String getAgainstObjectName();
}
