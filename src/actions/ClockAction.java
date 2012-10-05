package actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import utilities.Actions;
import utilities.Constants;
import game.GameObject;
import interfaces.Action;

public class ClockAction implements Action{
	private long gameTime;
	private Color color;
	
	public ClockAction(){
		this.gameTime = 0;
		this.color = Constants.CLOCK_DEFAULT_COLOR;
	}
	
	@Override
	public void act(GameObject gameObject) {
		gameTime += Constants.FRAME_TIME_MS;
		long clockSeconds = gameTime/1000;
		long clockMinutes = clockSeconds/60;
		clockSeconds = clockSeconds % 60;
		BufferedImage image = new BufferedImage((int)gameObject.getWidth(), (int)gameObject.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		String family = "Serif";
	    int style = Font.BOLD;
	    int size = (int)gameObject.getHeight()-4;
	    if(size<10) size=10;
	    Font font = new Font(family, style, size);
	    g.setColor(this.color);
	    g.setFont(font);
	    g.drawString((int)clockMinutes + ":" + (int)clockSeconds, 0, (int)gameObject.getHeight()-2);
	    gameObject.setImage(image);
	}

	@Override
	public Actions getActionType() {
		return Actions.CLOCK;
	}
	
	public void setColor(Color color){
		this.color = color;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		
		
	}

	@Override
	public String getAgainstObjectName() {
		
		return null;
	}

}
