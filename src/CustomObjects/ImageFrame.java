package CustomObjects;

import game.Game;
import game.GameObject;
import gameMaker.GameMaker;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.*;

import utilities.Constants;
import utilities.Event;
import utilities.Helper;
import utilities.Layers;

import net.miginfocom.swing.MigLayout;

public class ImageFrame extends JFrame implements ActionListener{
	
	private JScrollPane scrollBar;
	private JPanel panel;
	private JButton okbutton;
	private ButtonGroup group;
	private JTextField type,name;
	private JComboBox layerBox;
	private String layer;
	private boolean isBackground = false;
	
	public ImageFrame(){
		panel=new JPanel();
		okbutton = new JButton("OK");
		panel.setLayout(new MigLayout("","[]30[]")); 
		scrollBar = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		type= new JTextField("",10);
		name= new JTextField("",10);
		
		File folder = new File("images");
	    File[] listOfFiles = folder.listFiles();
	    group = new ButtonGroup();
	    panel.add(new JLabel("Object Name: "));
	    panel.add(name,"wrap");
	    panel.add(new JLabel("Object Type: "));
	    panel.add(type,"wrap");
	    panel.add(new JLabel("Layer: "));
	    layerBox = new JComboBox(Layers.getInstance().getLayers().toArray()); 
	    panel.add(layerBox,"wrap");
	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        try {
	        	JRadioButton jrbutton = new JRadioButton(listOfFiles[i].getName());
	        	Image image = Toolkit.getDefaultToolkit().getImage(listOfFiles[i].getCanonicalPath());
	        	ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, 1));
	        	JLabel iconimage = new JLabel(icon);
	        	group.add(jrbutton);
	        	panel.add(jrbutton);
	        	panel.add(iconimage,"wrap");
			} catch (IOException e) {
				e.printStackTrace();
			}
	      } 
	    }
	    panel.add(okbutton);
	    setSize(400, 600);
	    add(scrollBar);
	    setFocusable(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setTitle("Choose a image");
	    setVisible(false);
	    
	    layerBox.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  layer = ((String) ((JComboBox) e.getSource()).getSelectedItem());
		    	  if(layer.equalsIgnoreCase(Constants.NEW_LAYER)) {
		    		  layer = Layers.getInstance().addNewLayer();
		    	  }
		      }
		 });

	    okbutton.addActionListener(this);

	}
	
	public ImageFrame(boolean isBackground){
		this();
		this.isBackground = isBackground;
	}

	
	public JRadioButton getSelection() {
	    for (Enumeration e=group.getElements(); e.hasMoreElements(); ) {
	        JRadioButton b = (JRadioButton)e.nextElement();
	        if (b.getModel() == group.getSelection()) {
	            return b;
	        }
	    }
	    return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!name.getText().equalsIgnoreCase("")&&!type.getText().equalsIgnoreCase("")&& !(getSelection()==null)){
			String filepath = "images/"+getSelection().getText();	
			setVisible(false);
			if(layer==null)
				layer = ((String) layerBox.getSelectedItem());
			if(layer.equalsIgnoreCase(Constants.NEW_LAYER)) {
	    		  layer = Layers.getInstance().addNewLayer();
	    	}
			Game.getSharedGame().getBoard().setCurrentLayer(layer);
			if(isBackground){
				Game.getSharedGame().getBoard().setBackGroundImagePath(filepath);
			}
			else{
				GameMaker.getInstance().createNewObject(filepath,type.getText(),name.getText(), layer);
			}
			
		}else{
			JOptionPane.showMessageDialog(this, "Please select an image and enter the Object type/name");
		}
	}
}
