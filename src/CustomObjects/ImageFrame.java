package CustomObjects;

import game.Game;
import game.GameObject;
import gameMaker.GameMaker;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.*;

import utilities.Constants;
import utilities.Event;
import utilities.Helper;
import utilities.Layers;

import net.miginfocom.swing.MigLayout;

public class ImageFrame extends JFrame{
	
	private JScrollPane scrollBar;
	private JPanel panel;
	private JTextField type,name;
	private JComboBox layerBox;
	private String layer;
	private boolean isBackground = false;
	
	public ImageFrame(){
		panel=new JPanel();

		panel.setLayout(new MigLayout("","[]30[]10[]")); 
		scrollBar = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		type= new JTextField("",8);
		name= new JTextField("",8);
		
		File folder = new File(getClass().getResource("/").getPath());
	    File[] listOfFiles = folder.listFiles(new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.toLowerCase().endsWith(".png");
	        }
	    });
	    
	    panel.add(new JLabel("Object Name: "));
	    panel.add(name,"wrap");
	    panel.add(new JLabel("Object Type: "));
	    panel.add(type,"wrap");
	    panel.add(new JLabel("Layer: "));
	    layerBox = new JComboBox(Layers.getInstance().getLayers().toArray()); 
	    panel.add(layerBox,"wrap");
	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/"+listOfFiles[i].getName()));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, 1));
			final JLabel iconimage = new JLabel(icon);
			iconimage.setToolTipText(listOfFiles[i].getName());
			iconimage.addMouseListener(new MouseAdapter() {
			      public void mouseClicked(MouseEvent e) {
			    	  if(!name.getText().equalsIgnoreCase("")&&!type.getText().equalsIgnoreCase("")){
			  			String filepath = getClass().getResource("/").getPath() + iconimage.getToolTipText();
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
			  			JOptionPane.showMessageDialog(scrollBar, "Please select an image and enter the Object type/name");
			  		}
			  		
			        }
			      });
			

			if ((i+1)%3==0){
			panel.add(iconimage,"wrap");
			}else{
				panel.add(iconimage);
			}
	      } 
	    }

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

	   // okbutton.addActionListener(this);

	}
	
	public ImageFrame(boolean isBackground){
		this();
		this.isBackground = isBackground;
	}


}
