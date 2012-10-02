package gameMaker;

import org.apache.log4j.PropertyConfigurator;

import CustomObjects.ImageFrame;

public class Main {
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(Main.class);

	private void configureLog4j() {
		PropertyConfigurator.configure("log4j.properties");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new Main()).configureLog4j();
		LOG.info("Creating GameMaker");
		GameMaker gm = new GameMaker();
		ImageFrame imf = new ImageFrame();
		gm.setImageframe(imf);
	}

}
