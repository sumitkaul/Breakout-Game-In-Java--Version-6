package actions;

import game.Game;
import game.GameObject;
import interfaces.Action;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import utilities.Actions;
import utilities.Constants;

public class CollideBounceAction implements Action {
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
	.getLogger(CollideBounceAction.class);
	
	private String againstObjectName;
	@Override
	public void act(GameObject gameObject) {
		LOG.debug("executing collision action for " + gameObject);
		double xSpeed = gameObject.getXSpeed();
		double ySpeed = gameObject.getYSpeed();

		Game game = Game.getSharedGame();
		Rectangle2D.Double xReversed = (Rectangle2D.Double) gameObject.getBounds();
		Rectangle2D.Double yReversed = (Rectangle2D.Double) gameObject.getBounds();		
		xReversed.x -= xSpeed;
		yReversed.y -= ySpeed;
		ArrayList<GameObject> gameObjects = (ArrayList<GameObject>) Game.getSharedGame().getGameObjects();
		//ArrayList<GameObject> collidingGameObjects = new ArrayList<GameObject>();
		for(GameObject obj : gameObjects){
			if(obj.equals(gameObject)) continue;
			if(obj.getName().equals(getAgainstObjectName())) {
				if(gameObject.intersects(obj.getBounds())){
					if(!xReversed.intersects(obj.getBounds())){
						gameObject.setXSpeed(xSpeed*-1);
					}
					if(!yReversed.intersects(obj.getBounds())){
						gameObject.setYSpeed(ySpeed*-1);
					}
					else if(yReversed.intersects(obj.getBounds())&&xReversed.intersects(obj.getBounds())){
						gameObject.setYSpeed(ySpeed*-1);
						gameObject.setXSpeed(xSpeed*-1);
					}
					
				}
			}
		}
		if(getAgainstObjectName().equals(Constants.GAME_WALL)) {
			if(gameObject.getX()+gameObject.getWidth()>game.getBoard().getWidth()){
				if(xSpeed>0){
					gameObject.setXSpeed(xSpeed*-1);
				}
			}
			else if(gameObject.getX()<0){
				if(xSpeed<0){
					gameObject.setXSpeed(xSpeed*-1);
				}
			}
			if(gameObject.getY()+gameObject.getHeight()>game.getBoard().getHeight()){
				if(ySpeed>0){
					gameObject.setYSpeed(ySpeed*-1);
				}
			}
			else if(gameObject.getY()<0){
				if(ySpeed<0){
					gameObject.setYSpeed(ySpeed*-1);
				}
			}
		}
	}

	@Override
	public Actions getActionType() {
		
		return Actions.BOUNCE;
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
