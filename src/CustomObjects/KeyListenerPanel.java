package CustomObjects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Event;
import utilities.Helper;

public class KeyListenerPanel extends JPanel implements KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JLabel infoLbl;
	private Event associatedEventType;
	
	/*
	 * This panel will be used to get user inputs from user. Not fully implemented.
	 */
	public KeyListenerPanel(){
		super();
		setFocusable(true);
		  infoLbl = new JLabel();
		  infoLbl.setText("Click & press a key");
		  infoLbl.setForeground(Color.WHITE);
		  add(infoLbl);
		  
//		  currentKeyPressedLabel = new JLabel();
//		  currentKeyPressedLabel.setText("No key pressed");
//		  currentKeyPressedLabel.setForeground(Color.white);
//		  add(currentKeyPressedLabel);
		  
		  addKeyListener(this);
		  addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Helper.getSharedHelper().setCurrentKeyCode(e.getKeyCode());
		String charTyped = KeyEvent.getKeyText(e.getKeyCode());
		infoLbl.setText("You have selected :"+charTyped);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public Event getAssociatedEventType() {
		return associatedEventType;
	}

	public void setAssociatedEventType(Event associatedEventType) {
		this.associatedEventType = associatedEventType;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		requestFocus();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
