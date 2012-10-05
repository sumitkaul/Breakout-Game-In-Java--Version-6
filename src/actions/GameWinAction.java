package actions;

import java.util.ArrayList;
import game.Game;
import game.GameObject;
import interfaces.Action;
import javax.swing.JOptionPane;
import utilities.Actions;
import utilities.Constants;

public class GameWinAction implements Action {
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
	.getLogger(GameWinAction.class);
	
	private String againstObjectName;
	
	@Override
	public void act(GameObject gameObject) {
		LOG.debug("Executing GameWin action");
		
		ArrayList<GameObject> gameObjects = (ArrayList<GameObject>) Game.getSharedGame().getGameObjects();
		for(GameObject obj : gameObjects){
			if(obj.equals(gameObject)) continue;
			if(obj.getName().equals(getAgainstObjectName())) {
				if(gameObject.intersects(obj.getBounds())){
					JOptionPane.showMessageDialog(null, "You Won");
					Game.getSharedGame().stop();
				}
			}
		}
		
		if(getAgainstObjectName().equals(Constants.GAME_WALL)) {
			JOptionPane.showMessageDialog(null, "You Won");
			Game.getSharedGame().stop();
		}
	}

	@Override
	public Actions getActionType() {
		return Actions.GAME_OVER;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		this.againstObjectName = againstObjectName;
	}

	@Override
	public String getAgainstObjectName() {
		return againstObjectName;
	}
}
