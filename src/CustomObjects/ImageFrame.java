package CustomObjects;

import game.Game;
import gameMaker.GameMaker;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.*;

import utilities.Constants;
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
		
		//File system
		/*
		File folder = new File(getClass().getResource("/").getPath());
	    File[] listOfFiles = folder.listFiles(new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.toLowerCase().endsWith(".png");
	        }
	    });
	    */
		//Jar
	    
		CodeSource src = getClass().getProtectionDomain().getCodeSource();
		List<String> list = new ArrayList<String>();
		
		if( src != null ) {
		    URL jar = src.getLocation();
		    ZipInputStream zip;
			try {
				zip = new ZipInputStream(jar.openStream());
				ZipEntry ze = null;

				    while((ze = zip.getNextEntry()) != null) {
				        String entryName = ze.getName();
				        if(entryName.endsWith(".png") ) {
				            list.add(entryName);
				        }
				    }
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		 }
		
	    panel.add(new JLabel("Object Name: "));
	    panel.add(name,"wrap");
	    panel.add(new JLabel("Object Type: "));
	    panel.add(type,"wrap");
	    panel.add(new JLabel("Layer: "));
	    layerBox = new JComboBox(Layers.getInstance().getLayers().toArray()); 
	    panel.add(layerBox,"wrap");
	    
		    
	    for (int i = 0; i < list.size(); i++) {
	 
	        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/"+list.get(i)));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, 1));
			final JLabel iconimage = new JLabel(icon);
			iconimage.setToolTipText(list.get(i));
			iconimage.addMouseListener(new MouseAdapter() {
			      public void mouseClicked(MouseEvent e) {
			    	  if(!name.getText().equalsIgnoreCase("")&&!type.getText().equalsIgnoreCase("")){
			  			String filename = iconimage.getToolTipText();
			  			setVisible(false);
			  			if(layer==null)
			  				layer = ((String) layerBox.getSelectedItem());
			  			if(layer.equalsIgnoreCase(Constants.NEW_LAYER)) {
			  	    		  layer = Layers.getInstance().addNewLayer();
			  	    	}
			  			Game.getSharedGame().getBoard().setCurrentLayer(layer);
			  			if(isBackground){
			  				Game.getSharedGame().getBoard().setBackGroundImagePath(filename);
			  			}
			  			else{
			  				GameMaker.getInstance().createNewObject(filename,type.getText(),name.getText(), layer);
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

	    setSize(400, 600);
	    add(scrollBar);
	    setFocusable(true);
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


	}
	
	public ImageFrame(boolean isBackground){
		this();
		this.isBackground = isBackground;
	}


}
