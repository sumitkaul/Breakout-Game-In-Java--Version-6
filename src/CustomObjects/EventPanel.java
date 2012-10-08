package CustomObjects;

import game.Game;
import game.GameObject;
import interfaces.Action;
import interfaces.GameObjectObserver;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import net.miginfocom.swing.MigLayout;
import utilities.ActionObject;
import utilities.Actions;
import utilities.Constants;
import utilities.Event;
import utilities.Helper;
import utilities.Layers;
import actions.StartOverAction;



public class EventPanel extends JPanel implements GameObjectObserver{
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
	.getLogger(EventPanel.class);

	private static final long serialVersionUID = 1L;
	private Event eventType;

	private JLabel eventLabel;
	private JComboBox eventComboBox;
	private JLabel actionLabel;
	private JComboBox actionComboBox;
	private JLabel layerLabel;
	private JComboBox layerComboBox;
	private JButton addEventButton;
	private JButton removeEventButton;
	private CustomJList eventActionList;
	private JScrollPane jscrollPane;
	private KeyListenerPanel inputPanel;
	
	private DefaultListModel eventActionListModel;
	
	
	private static EventPanel sharedEventPanel = null;
	
	private int startX, startY;
	
	
	public static EventPanel getSharedEventPanel(){
		LOG.info("Getting static instance of the events Panel");
		if(sharedEventPanel == null){
			sharedEventPanel = new EventPanel();
		}
		return sharedEventPanel;
	}
	
	public EventPanel(){
		LOG.info("Adding Properties Panel");
		setBackground(Color.LIGHT_GRAY);
		setMaximumSize(new Dimension(200,400));
		
		Game.getSharedGame().registerForGameObjectUpdates(this);
		//Layout 2 here
		setLayout(new MigLayout());
		
		updateViewForEventType(Event.NEW_FRAME);
		
		layerLabel = new JLabel("Layers");
  		add(layerLabel,"wrap");
  		
  		List layerList = Layers.getInstance().getLayers();
		layerComboBox = new JComboBox(layerList.toArray());
		layerComboBox.addItem(Constants.ALL_LAYERS);
		add(layerComboBox,"wrap,grow");
		
		eventLabel = new JLabel();
  		eventLabel.setText("Events");
  		add(eventLabel,"wrap");
  		
  		String[] eventList = Helper.getSharedHelper().getAllEvents();
		eventComboBox = new JComboBox(eventList);
		add(eventComboBox,"wrap,grow");
		
		actionLabel = new JLabel();
		actionLabel.setText("Action");
  		add(actionLabel,"wrap");
  		
		String[] actionList = Helper.getSharedHelper().getAllActions();
		actionComboBox = new JComboBox(actionList);
		add(actionComboBox,"wrap,grow");
 		  
		addEventButton = new JButton("Add");
		add(addEventButton,"wrap,grow");
		
		
		eventActionListModel = new DefaultListModel();
		eventActionList = new CustomJList(eventActionListModel);
		eventActionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		eventActionList.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		jscrollPane = new JScrollPane(eventActionList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jscrollPane,"wrap,grow,wmin 200,hmin 80");
		
		removeEventButton = new JButton("Remove");
		add(removeEventButton,"wrap,grow");
					
		/*
		 * TO-DO : When events, link and action is selected, and if the user presses add, the respective object 
		 * has to register itself with the game controller. Once registered, the game controller will notify the 
		 * respective game object when such an event occurs. The game objects knows what to do as we have defined 
		 * the action is should perform.
		 */ 
				
		addEventButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				

	    		  Event event = Helper.getSharedHelper().getEventForString((String) eventComboBox.getSelectedItem());
	    		  Actions action = Helper.getSharedHelper().getActionForString((String) actionComboBox.getSelectedItem());
	    		  
	    		  Action act = Helper.getSharedHelper().getActionForId(action);
	    		  String actionName = (String) actionComboBox.getSelectedItem();
	    		  if(actionName.equalsIgnoreCase(Helper.getSharedHelper().getActionNameForId(Actions.START_OVER))){
	    			  StartOverAction startOver = (StartOverAction) act;
	    			  startOver.setStartX(startX);
	    			  startOver.setStartY(startY);
	    		  }
	    		  if(act == null)
	    			  return;
					GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
					String againstObjectName = "";
					if(event==Event.COLLISION_AGAINST) {
			    		  List<GameObject> allOtherGameObjects = new ArrayList<GameObject>();
			    		  for(GameObject object : Game.getSharedGame().getGameObjects()) {
			    			  if(object!=selectedGameObject)
			    				  allOtherGameObjects.add(object);
			    		  }
			    		  // Special case for Game Wall as it cannot be added as a GameObject. 
			    		  Object[] possibilities = new Object[allOtherGameObjects.size()+2];
			    		  for(int i=0;i<allOtherGameObjects.size();i++){
			    			  possibilities[i] = allOtherGameObjects.get(i).getName();
			    		  }
				    	  possibilities[allOtherGameObjects.size()] = Constants.GAME_WALL;
				    	  possibilities[allOtherGameObjects.size()+1] = Constants.ANY_OBJECT;
				    	  againstObjectName = (String)JOptionPane.showInputDialog(null,
				    			    "Choose the object against which you want to define the collision event",
				    			    "Object Selection",
				    			    JOptionPane.PLAIN_MESSAGE,null,possibilities,null);
				    	  if(againstObjectName !=null) {
				    		 if(againstObjectName.equalsIgnoreCase(Constants.ANY_OBJECT)) {
					    		  LOG.info("The collision event is against object "+againstObjectName);
					    		  for(GameObject obj : Game.getSharedGame().getGameObjects()) {
					    			  if(obj!=selectedGameObject) {
										  selectedGameObject.addAction(event.getEventCode(), act, obj.getName());
					    				  obj.addAction(event.getEventCode(), act, selectedGameObject.getName());
					    			  }
					    		  }
					    	  } else if(againstObjectName.equalsIgnoreCase(Constants.GAME_WALL)){
					    		  selectedGameObject.addAction(event.getEventCode(), act, againstObjectName);
					    	  } else {
					    		  LOG.info("The collision event is against object "+againstObjectName);
					    		  selectedGameObject.addAction(event.getEventCode(), act, againstObjectName);
						    	  GameObject againstObject = Game.getSharedGame().getGameObjectByName(againstObjectName);
						    	  againstObject.addAction(event.getEventCode(), act, selectedGameObject.getName());
					    	  }
				    	  }
			    	  	} else {
						if(selectedGameObject != null)
							selectedGameObject.addAction(event.getEventCode(), act, againstObjectName);
			    	  }

					updateProperties();
	
			}
		});
		
		removeEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				for (Object element : eventActionList.getSelectedValues()) {

					String testString = (String) element;
					String[] stringComponents = testString.split("--->");
					Event event = Helper.getSharedHelper().getEventForString(
							stringComponents[0]);
					Actions action = Helper.getSharedHelper().getActionForString(
							stringComponents[1]);

					GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
					HashMap<Integer, List<ActionObject>> eventActionMap = selectedGameObject.getEventActionMap();

					
					List<ActionObject> actionObjectList = new ArrayList<ActionObject>();
					actionObjectList.addAll(eventActionMap.get(event.getEventCode()));
					for(ActionObject actionObject : actionObjectList) {
						if(action.equals(actionObject.getAction()))
							eventActionMap.get(event.getEventCode()).remove(actionObject);
					}
					selectedGameObject.setEventActionMap(eventActionMap);

					eventActionList.getListModel().removeElement(element);

				}

			}
		});
		
		layerComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String layer = (String)layerComboBox.getSelectedItem();
				if(layer.equalsIgnoreCase(Constants.NEW_LAYER)) {
					layer = Layers.getInstance().addNewLayer();
					Game.getSharedGame().getBoard().setCurrentLayer(layer);
				} else {
					Game.getSharedGame().getBoard().setCurrentLayer(layer);
				}
				Game.getSharedGame().draw();
			}
		});

		eventComboBox.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Event event = Helper.getSharedHelper().getEventForString((String) ((JComboBox) e.getSource()).getSelectedItem());
		    	  updateViewForEventType(event);
		      }
		    });
		
		actionComboBox.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  JComboBox cb = (JComboBox) e.getSource();
					String actionName = (String) cb.getSelectedItem();
					if(actionName.equalsIgnoreCase(Helper.getSharedHelper().getActionNameForId(Actions.START_OVER))){
						String[] combo = { "Start of frame",
								"End of frame",
								"Present value"
						};
						JComboBox startXCombo = new JComboBox(combo);
						startXCombo.setEditable(true);
						JComboBox startYCombo = new JComboBox(combo);
						startYCombo.setEditable(true);
			  			final JComponent[] inputs = new JComponent[] {
			  			                new JLabel("Start X position"),
			  			              startXCombo,
			  			                new JLabel("Start Y position"),
			  			              startYCombo,
			  			};
			  			JOptionPane.showMessageDialog(null, inputs, "Start positions", JOptionPane.PLAIN_MESSAGE);
			  			String xval = (String) startXCombo.getSelectedItem();
			  			if(xval.equalsIgnoreCase("Start of frame")){
			  				startX = 0;
			  			}
			  			else if(xval.equalsIgnoreCase("End of frame")){
			  				startX = Game.getSharedGame().getBoard().getWidth();
			  			}
			  			else if(xval.equalsIgnoreCase("Present value")){
			  				startX = (int) Game.getSharedGame().getSelectedGameObject().getX();
			  			}
			  			else{
			  				 startX = Integer.parseInt(xval);
			  			}
			  			String yval = (String) startYCombo.getSelectedItem();
			  			if(yval.equalsIgnoreCase("Start of frame")){
			  				startY = 0;
			  			}
			  			else if(yval.equalsIgnoreCase("End of frame")){
			  				startY = Game.getSharedGame().getBoard().getHeight();
			  			}
			  			else if(yval.equalsIgnoreCase("Present value")){
			  				startY = (int) Game.getSharedGame().getSelectedGameObject().getY();
			  			}
			  			else{
			  				 startY = Integer.parseInt(yval);
			  			}
			  			
					}
		    	  Actions action = Helper.getSharedHelper().getActionForString((String) ((JComboBox) e.getSource()).getSelectedItem());
		    	  if(action == Actions.CHECK_OVERLAP){
		    		  GameObject selectedObject = Game.getSharedGame().getSelectedGameObject(); 
		    		  List<String> otherTypes = new ArrayList<String>();
		    		  for (String type : Game.getSharedGame().getGameType()){
		    			  if(!type.equalsIgnoreCase(selectedObject.getObjecttype())){
		    				  if(!otherTypes.contains(type)){
		    					  otherTypes.add(type);
		    				  }
		    			  }
		    		  }
		    		  Object[] possibilities = otherTypes.toArray();
		    		  if(possibilities.length>0) {
			    		  String checkType = (String) JOptionPane.showInputDialog(null,
				    			    "Choose the object type which you want to check",
				    			    "Object Type Selection",
				    			    JOptionPane.PLAIN_MESSAGE,null,possibilities,null);
			    		  selectedObject.addToCheckTypeList(checkType);
				    	  } else {
				    		  JOptionPane.showMessageDialog(null,
					    			    "Game Only has one type",
					    			    "",
					    			    JOptionPane.WARNING_MESSAGE);
				    	  }

		    	  }
		      }
		});
	}
	

	/*
	 * Updates the event panel based on what event has been selected. 
	 */
	private void updateViewForEventType(Event eType){
		setEventType(eType);
	
  	  if(eType == Event.COLLISION_AGAINST){
  		  if(inputPanel != null){
  			remove(inputPanel);
  	  		validate();
  	  		repaint();
  		  }
  	  }
  	  
  	 else if(eventType == Event.NEW_FRAME){
  		 if(inputPanel != null){
   			remove(inputPanel);
   	  		validate();
   	  		repaint();
   		  }
   	  }
  	 else if(eType == Event.MOUSE_LEFT_CLICK){
		  if(inputPanel != null){
			remove(inputPanel);
	  		validate();
	  		repaint();
		  }
	  }
	  
	 else if(eventType == Event.MOUSE_RIGHT_CLICK){
		 if(inputPanel != null){
 			remove(inputPanel);
 	  		validate();
 	  		repaint();
 		  }
 	  }
	 else if(eventType == Event.MOUSE_MIDDLE_CLICK){
		 if(inputPanel != null){
 			remove(inputPanel);
 	  		validate();
 	  		repaint();
 		  }
 	  }
	  else if(eventType == Event.OUT_OF_BOUNDARY){
	 	 if(inputPanel != null){
	  		remove(inputPanel);
	  		validate();
	  		repaint();
	  	  }
	   }
 	  else { //INPUT
   		 if(inputPanel != null)
   			 remove(inputPanel);
   	
   		inputPanel = new KeyListenerPanel();
 		  inputPanel.setAssociatedEventType(eventType);
 		  inputPanel.setBackground(Color.darkGray);
 		  add(inputPanel,"grow");
   		  validate();
   	  }
	}
	
	public Event getEventType() {
		return eventType;
	}

	public void setEventType(Event eventType) {
		this.eventType = eventType;
	}

	@Override
	public void updateProperties() {
		
		eventActionListModel.removeAllElements();
		
		GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
		HashMap<Integer,List<ActionObject>> eventActionMap =  selectedGameObject.getEventActionMap();
		if(eventActionMap == null)
			return;
		Set<Integer> events = eventActionMap.keySet();
		Iterator<Integer> eventIterator = events.iterator();
		while(eventIterator.hasNext()){
			int event = eventIterator.next();
			List<ActionObject> actionList = eventActionMap.get(event);
			
			String eventString = Helper.getSharedHelper().getEventNameForId(event);

			if(actionList != null){
				for(ActionObject actionObject :actionList){
					String actionString = Helper.getSharedHelper().getActionNameForId(actionObject.getAction().getActionType());
					String objectString = actionObject.getGameObjectName();
					String message = eventString+"--->"+actionString;
					if(!actionObject.getGameObjectName().isEmpty()) {
						message += "--->"+objectString;
					}
					LOG.info("Event--->Action : "+message);
					eventActionListModel.addElement(message);
				}
			}

		}
		 jscrollPane.setVisible(true);
		
	}

	public JComboBox getLayerComboBox() {
		return layerComboBox;
	}

	public void setLayerComboBox(JComboBox layerComboBox) {
		this.layerComboBox = layerComboBox;
	}

}
