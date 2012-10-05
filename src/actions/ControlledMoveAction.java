package actions;

import utilities.Actions;
import game.GameObject;
import interfaces.Action;

public class ControlledMoveAction implements Action {
	private double xSpeed;
	private double ySpeed;
	
	public ControlledMoveAction(double xSpeed, double ySpeed){
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	@Override
	public void act(GameObject gameObject) {
//		if(gameObject.getXSpeed()>0||gameObject.getYSpeed()>0){
//			gameObject.setXSpeed(0);
//			gameObject.setYSpeed(0);
//		}
//		else {
//			gameObject.setXSpeed(xSpeed);
//			gameObject.setYSpeed(ySpeed);
//		}
		
		double x = gameObject.getX();
		gameObject.setX(x + this.xSpeed);
		double y = gameObject.getY();
		gameObject.setY(y + this.ySpeed);
	}
	
	public double getXSpeed(){
		return this.xSpeed;
	}
	public void setXSpeed(double xSpeed){
		this.xSpeed = xSpeed;
	}
	
	public double getYSpeed(){
		return this.ySpeed;
	}
	public void setYSpeed(double ySpeed){
		this.ySpeed = ySpeed;
	}
	
	public String toString(){
		String retString = new String("ControlledMoveAction xspeed:" + xSpeed + " yspeed:" + ySpeed);
		return retString;
	}
	
	@Override
	public Actions getActionType() {
		
		return Actions.CONTROLLED_MOVE;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		
		
	}

	@Override
	public String getAgainstObjectName() {
		
		return null;
	}

}
