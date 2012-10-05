package actions;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilities.Actions;
import game.Game;
import game.GameObject;
import interfaces.Action;

public class CheckOverlapAction implements Action{

	@Override
	public void act(GameObject gameObject) {
		if(gameObject.equals(Game.getSharedGame().getSelectedGameObject())){
			if(gameObject.equals(Game.getSharedGame().getSelectedGameObject())){
				gameObject.unregisterFromGame();
			ArrayList<GameObject> gameObjects = (ArrayList<GameObject>) Game.getSharedGame().getGameObjects();
			for(GameObject obj : gameObjects){
				if(obj.equals(gameObject)) continue;
				if(gameObject.intersects(obj.getBounds())){
					if(gameObject.getCheckTypeList().contains(obj.getObjecttype())){
						JOptionPane.showMessageDialog(null, "You Lose");
					}
					gameObject.unregisterFromGame();
				}
			}
		}
		}
	}

	@Override
	public Actions getActionType() {
	
		return Actions.CHECK_OVERLAP;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		
		
	}

	@Override
	public String getAgainstObjectName() {
		
		return null;
	}

}
