package utilities;


import game.GameObject;
import interfaces.Action;

import java.util.ArrayList;

import CustomObjects.CustomComboBox;
import CustomObjects.PropertiesPanel;
import actions.AddFlagAction;
import actions.AddQuestionMAction;
import actions.CheckOverlapAction;
import actions.CollideBounceAction;
import actions.ControlledMoveAction;
import actions.GameOverAction;
import actions.GameWinAction;
import actions.NormalMoveAction;
import actions.PlaySoundAction;
import actions.RemoveAction;
import actions.ShotAction;
import actions.StartOverAction;




public class Helper {
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
	.getLogger(Helper.class);
	public static Helper sharedHelper = null;
	private String[] eventList;
	private String[] actionList;
	private int currentKeyCode;
	private ArrayList<GameObject> gameObjectsToBeRemoved;
	
	public static Helper getSharedHelper() {
	      if(sharedHelper == null) {
	    	  sharedHelper = new Helper();
	      }
	      return sharedHelper;
	   }
	
	public Helper() {
		setGameObjectsToBeRemoved(new ArrayList<GameObject>());
	}
	
	public String[] getAllEvents(){
		if(eventList == null){
			eventList = new String[7];
			eventList[0] = getEventNameForId(Event.NEW_FRAME.getEventCode());
			eventList[1] = getEventNameForId(Event.COLLISION_AGAINST.getEventCode());
			eventList[2] = "Input";
			eventList[3] = getEventNameForId(Event.MOUSE_LEFT_CLICK.getEventCode());
			eventList[4] = getEventNameForId(Event.MOUSE_RIGHT_CLICK.getEventCode());
			eventList[5] = getEventNameForId(Event.MOUSE_MIDDLE_CLICK.getEventCode());
			eventList[6] = getEventNameForId(Event.OUT_OF_BOUNDARY.getEventCode());
		}
	
		return eventList;
	}
	
	public CustomComboBox createComboBox(ArrayList<String> listItems, String title){
		CustomComboBox customComboBox = new CustomComboBox(listItems,title);
		return customComboBox;
	}

	public String[] getAllActions() {
		if(actionList == null){
			actionList = new String[12];
			actionList[0] = getActionNameForId(Actions.NORMAL_MOVE);
			actionList[1] = getActionNameForId(Actions.CONTROLLED_MOVE);
			actionList[2] = getActionNameForId(Actions.REMOVE);
			actionList[3] = getActionNameForId(Actions.BOUNCE);
			actionList[4] = getActionNameForId(Actions.SOUND);
			actionList[5] = getActionNameForId(Actions.CHECK_OVERLAP);
			actionList[6] = getActionNameForId(Actions.REPLACE1);
			actionList[7] = getActionNameForId(Actions.REPLACE2);
			actionList[8] = getActionNameForId(Actions.START_OVER);
			actionList[9] = getActionNameForId(Actions.GAME_OVER);
			actionList[10] = getActionNameForId(Actions.GAME_WIN);
			actionList[11] = getActionNameForId(Actions.SHOT);
		}
		return actionList;
	}
	
	public String getEventNameForId(int eventcode){
		if(eventcode == Event.COLLISION_AGAINST.getEventCode())
			return "Collision Against";
		else if(eventcode == Event.MOUSE_LEFT_CLICK.getEventCode())
			return "Mouse left click";
		else if(eventcode == Event.NEW_FRAME.getEventCode())
			return "New Frame";
		else if(eventcode == Event.MOUSE_RIGHT_CLICK.getEventCode())
			return "Mouse right click";
		else if(eventcode == Event.MOUSE_MIDDLE_CLICK.getEventCode())
			return "Mouse middle click";
		else if(eventcode == Event.OUT_OF_BOUNDARY.getEventCode())
			return "Out of Boundary";
		else //if (event == Event.INPUT)
			return "Input";
	}
	
	public Event getEventForString(String eventString){
		if(eventString.equalsIgnoreCase("Collision Against"))
			return Event.COLLISION_AGAINST;
		else if(eventString.equalsIgnoreCase("New Frame"))
			return Event.NEW_FRAME;
		else if(eventString.equalsIgnoreCase("Mouse left click"))
			return Event.MOUSE_LEFT_CLICK;
		else if(eventString.equalsIgnoreCase("Mouse right click"))
			return Event.MOUSE_RIGHT_CLICK;
		else if(eventString.equalsIgnoreCase("Mouse middle click"))
			return Event.MOUSE_MIDDLE_CLICK;
		else if(eventString.equalsIgnoreCase("Out of Boundary"))
			return Event.OUT_OF_BOUNDARY;
		else if(eventString.equalsIgnoreCase("Input")){
			LOG.info("creating new input event with code " + this.currentKeyCode);
			Event event = new Event(this.currentKeyCode);
			return event;
		}
		return null;
	}
	
	public String getActionNameForId(Actions action){
		if(action == Actions.BOUNCE)
			return "Bounce";
		else if(action == Actions.NORMAL_MOVE)
			return "Normal Move";
		else if(action == Actions.CONTROLLED_MOVE)
			return "Controlled Move";
		else if(action == Actions.REMOVE)
			return "Remove";
		else if(action == Actions.SOUND)
			return "Sound";
		else if(action == Actions.CHECK_OVERLAP)
			return "Check Overlap";
		else if(action == Actions.REPLACE1)
			return "Replace with Flag";
		else if(action == Actions.REPLACE2)
			return "Replace with ? sign";
		else if(action == Actions.START_OVER)
			return "Start Over";
		else if(action == Actions.GAME_OVER)
			return "Game Over";
		else if(action == Actions.GAME_WIN)
			return "Game Win";
		else if(action == Actions.SHOT)
			return "Shot";
		return null;
	}
	
	public Actions getActionForString(String actionString){
		if(actionString.equalsIgnoreCase("Normal Move"))
			return Actions.NORMAL_MOVE;
		else if(actionString.equalsIgnoreCase("Controlled Move"))
			return Actions.CONTROLLED_MOVE;
		else if(actionString.equalsIgnoreCase("Remove"))
			return Actions.REMOVE;
		else if(actionString.equalsIgnoreCase("Bounce"))
			return Actions.BOUNCE;
		else if(actionString.equalsIgnoreCase("Sound"))
			return Actions.SOUND;
		else if(actionString.equalsIgnoreCase("Check Overlap"))
			return Actions.CHECK_OVERLAP;
		else if(actionString.equalsIgnoreCase("Replace with Flag"))
			return Actions.REPLACE1;
		else if(actionString.equalsIgnoreCase("Replace with ? sign"))
			return Actions.REPLACE2;
		else if(actionString.equalsIgnoreCase("Start Over"))
			return Actions.START_OVER;
		else if(actionString.equalsIgnoreCase("Game Over"))
			return Actions.GAME_OVER;
		else if(actionString.equalsIgnoreCase("Game Win"))
			return Actions.GAME_WIN;
		else if(actionString.equalsIgnoreCase("Shot"))
			return Actions.SHOT;
		return null;
	}
	
	public Action getActionForId(Actions action){
		if(action == Actions.NORMAL_MOVE){
			return (new NormalMoveAction());
		}
		else if(action == Actions.BOUNCE){
			return (new CollideBounceAction());
		}
		else if(action == Actions.CONTROLLED_MOVE){
			double xSpeed = 0.0;
			double ySpeed = 0.0;
			
			String xSpeedString = PropertiesPanel.getInstance().getSpeedXField().getText();
			String ySpeedString = PropertiesPanel.getInstance().getSpeedYField().getText();
			
			if(xSpeedString != null && xSpeedString.length() > 0)
				xSpeed = Double.parseDouble(xSpeedString);
			if(ySpeedString != null && ySpeedString.length() > 0)
				ySpeed = Double.parseDouble(ySpeedString);
			
			return (new ControlledMoveAction(xSpeed, ySpeed));
		}
		else if(action == Actions.SOUND){
			PlaySoundAction playAction = new PlaySoundAction();
			int returnValue =  playAction.initialize();
			if(returnValue == 1)
				return playAction;
			else 
				return null;
		}
		else if(action == Actions.REMOVE){
			return (new RemoveAction());
		}else if(action == Actions.CHECK_OVERLAP){
			return (new CheckOverlapAction());
		}else if(action == Actions.REPLACE1){
			return (new AddFlagAction());
		}else if(action == Actions.REPLACE2){
			return (new AddQuestionMAction());
		}else if(action == Actions.START_OVER){
			return (new StartOverAction());
		}else if(action == Actions.GAME_OVER){
			return (new GameOverAction());
		}else if(action == Actions.GAME_WIN){
			return (new GameWinAction());
		}else if(action == Actions.SHOT){
			return (new ShotAction());
		}
		
		return null;
	}

	public int getCurrentKeyCode() {
		return currentKeyCode;
	}

	public void setCurrentKeyCode(int currentKeyCode) {
		this.currentKeyCode = currentKeyCode;
	}

	public ArrayList<GameObject> getGameObjectsToBeRemoved() {
		return gameObjectsToBeRemoved;
	}

	public void setGameObjectsToBeRemoved(ArrayList<GameObject> gameObjectsToBeRemoved) {
		this.gameObjectsToBeRemoved = gameObjectsToBeRemoved;
	}
	
	
}
