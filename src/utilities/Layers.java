/**
 * 
 */
package utilities;

import java.util.ArrayList;
import java.util.List;

import CustomObjects.EventPanel;

/**
 * @author Viknes
 *
 */
public class Layers {

	private static Layers layer;
	public static Layers getInstance() {
		if(layer==null)
			layer = new Layers();
		return layer;
	}
	List<String> layers;
	
	public List<String> getLayers() {
		return layers;
	}

	public void setLayers(List<String> layers) {
		this.layers = layers;
	}
	
	public String addNewLayer() {
		String layer = "Layer "+layers.size();
		this.layers.add(layer);
		EventPanel.getSharedEventPanel().getLayerComboBox().addItem(layer);
		return layer;
	}

	public Layers() {
		layers = new ArrayList<String>();
		layers.add(Constants.NEW_LAYER);
	}
	
	
}
