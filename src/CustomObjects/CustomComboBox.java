package CustomObjects;


import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Event;

public class CustomComboBox extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox comboBox = null;
	private Event associatedEventType;
	private String title;

	public CustomComboBox(ArrayList<String> listItems, String title) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setTitle(title);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setAlignmentX(LEFT_ALIGNMENT);
		titleLabel.setText(title);
		add(titleLabel);
		
		JComboBox comboBox = new JComboBox();
		setComboBox(comboBox);
		for(String listItem : listItems){
			comboBox.addItem(listItem);
		}
		add(comboBox);
		
	}

	
	public String getTitle() {
		return title;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public Event getAssociatedEventType() {
		return associatedEventType;
	}


	public void setAssociatedEventType(Event associatedEventType) {
		this.associatedEventType = associatedEventType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
