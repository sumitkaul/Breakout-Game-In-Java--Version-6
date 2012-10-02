package actions;

import javax.swing.JOptionPane;

import utilities.Actions;
import game.Game;
import game.GameObject;
import interfaces.Action;

public class AddQuestionMAction implements Action {

	@Override
	public void act(GameObject gameObject) {
		String imagepath = gameObject.getImageFile();
		if(gameObject.equals(Game.getSharedGame().getSelectedGameObject())){
		gameObject.setImageFile(imagepath.split("/")[0]+"/question.png");
		}
		
	}

	@Override
	public Actions getActionType() {
		// TODO Auto-generated method stub
		return Actions.REPLACE2;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAgainstObjectName() {
		// TODO Auto-generated method stub
		return null;
	}

}
