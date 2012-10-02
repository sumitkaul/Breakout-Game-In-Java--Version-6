package actions;

import game.GameObject;
import gameMaker.GameMaker;

import interfaces.Action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import utilities.Actions;

public class PlaySoundAction implements Action{
	
	private File clipName;
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
		try{
		this.setClipName(fileChooser.getSelectedFile());
		}
		catch (NullPointerException e)
		{
			LOG.info("File not selected");
		}
		LOG.info("The clipname is "+clipName);
		
		try {
			setInputAudioStream(new FileInputStream(clipName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOG.info("No File selected");
			return 0;
		}
		return 1;
		
	}
	public void writeToCache()
	{
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		//String s = "This should be in cache";
		byte buf[] = this.getClipName().toString().getBytes();
		try {
			f.write(buf);
		} catch (IOException e) {
			LOG.error(e);
		} 
	}
	public File getClipName() {
		return clipName;
	}

	public void setClipName(File clipName) {
		this.clipName = clipName;
	}

	public void act(GameObject gameObjects)
	{
		LOG.info("Playing Sound "+clipName);
		LOG.debug(""+getClass().getResource(clipName.toString()));
		AudioStream as;
		try {
			//TO-DO : It reads from the file every time. Need to change.
			as = new AudioStream(new FileInputStream(clipName));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAgainstObjectName() {
		// TODO Auto-generated method stub
		return null;
	}

}
