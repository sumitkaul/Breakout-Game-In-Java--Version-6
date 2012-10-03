package CustomObjects;

import game.Game;
import game.GameObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import utilities.ActionObject;
import utilities.Actions;
import utilities.Event;
import utilities.Helper;

public class CustomJList extends JList implements MouseListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel;
	private List selectedList;
	
	public CustomJList(DefaultListModel eventActionListModel) {
		super(eventActionListModel);
		setListModel(eventActionListModel);
		addMouseListener(this);
		addKeyListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JList list = (JList)arg0.getComponent();
		selectedList = list.getSelectedValuesList();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getKeyChar() == 'd'){
			for(Object element:selectedList){
				
				String testString = (String)element;
				String[] stringComponents = testString.split("--->");
				Event event = Helper.getSharedHelper().getEventForString(stringComponents[0]);
				
				Actions action = Helper.getSharedHelper().getActionForString(
						stringComponents[1]);
				GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
				HashMap<Integer, List<ActionObject>> eventActionMap = selectedGameObject.getEventActionMap();

				List<ActionObject> actionObjectList = new ArrayList<ActionObject>();
				actionObjectList.addAll(eventActionMap.get(event.getEventCode()));
				for(ActionObject actionObject : actionObjectList) {
					if(action.equals(actionObject.getAction().getActionType()))
						eventActionMap.get(event.getEventCode()).remove(actionObject);
				}
				selectedGameObject.setEventActionMap(eventActionMap);
/*
				
				GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
				HashMap<Integer,List<Action>> eventActionMap =  selectedGameObject.getEventActionMap();
				
				eventActionMap.remove(event.getEventCode());
				selectedGameObject.setEventActionMap(eventActionMap);
*/				
				getListModel().removeElement(element);
				
				
			}
			
			
		}
		
	}
	
	public List getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(List selectedList) {
		this.selectedList = selectedList;
	}

}
