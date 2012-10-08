package actions;

import game.GameObject;
import gameMaker.GameMaker;
import interfaces.Action;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import utilities.Actions;

public class PlaySoundAction implements Action{
	
	private String clipName;
	public InputStream getInputAudioStream() {
		return inputAudioStream;
	}

	public void setInputAudioStream(InputStream inputAudioStream) {
		this.inputAudioStream = inputAudioStream;
	}


	private InputStream inputAudioStream;
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(GameMaker.class);
	
	
	public PlaySoundAction()
	{
		

	}
	
	
	public int initialize(){
		LOG.info("Choosing File");
		//File system
		/*
		JFileChooser fileChooser = new JFileChooser("sounds");
		fileChooser.addChoosableFileFilter(new FileFilter()
		{
			
		        public boolean accept(File f) {
		          return f.getName().toLowerCase().endsWith(".wav")
		              || f.isDirectory();
		        }

				@Override
				public String getDescription() {
					return "WAV Files";
				}
		});
		fileChooser.showOpenDialog(new JFrame());
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
				        if(entryName.endsWith(".wav") || entryName.endsWith(".au") ) {
				            list.add(entryName);
				        }
				    }
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		 }
		String filename="";
		filename =  (String)JOptionPane.showInputDialog(null,
			    "Choose Sound File",
			    "Sound Selection",
			    JOptionPane.PLAIN_MESSAGE,null,list.toArray(),null);
		try{
		this.setClipName(filename);
		}
		catch (NullPointerException e)
		{
			LOG.info("File not selected");
		}
		LOG.info("The clipname is "+clipName);
		
		try {
			setInputAudioStream(getClass().getResourceAsStream("/"+clipName));
		} catch (NullPointerException e) {
			LOG.info("No File selected");
			return 0;
		}
		return 1;
		
	}
	public void writeToCache()
	{
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		byte buf[] = this.getClipName().toString().getBytes();
		try {
			f.write(buf);
		} catch (IOException e) {
			LOG.error(e);
		} 
	}
	public String getClipName() {
		return clipName;
	}

	public void setClipName(String clipName) {
		this.clipName = clipName;
	}

	public void act(GameObject gameObjects)
	{
		LOG.info("Playing Sound "+clipName);
		LOG.debug(""+getClass().getResource(clipName.toString()));
		AudioStream as;
		try {
			//TO-DO : It reads from the file every time. Need to change.
			as = new AudioStream(getClass().getResourceAsStream("/"+clipName));
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			LOG.info("Exception while trying to play audio");
		}         
		 
	}
	
	
	@Override
	public Actions getActionType() {
		return Actions.SOUND;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
	
		
	}

	@Override
	public String getAgainstObjectName() {
		
		return null;
	}

}
