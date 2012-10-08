package utilities;

public class Event {
	public static Event NEW_FRAME = new Event(13371);
	public static Event COLLISION_AGAINST = new Event(13372);

	public static Event MOUSE_LEFT_CLICK = new Event(13373);
	public static Event MOUSE_RIGHT_CLICK = new Event(13374);
	public static Event MOUSE_MIDDLE_CLICK = new Event(13375);
	public static Event OUT_OF_BOUNDARY = new Event(13376);

	
	private int eventCode;
	
	public Event(int eventCode){
		this.eventCode = eventCode;
	}
	public int getEventCode(){
		return this.eventCode;
	}
//	public int getKeyCode() {
//		return keyCode;
//	}
//	public void setKeyCode(int keyCode) {
//		this.eventCode = keyCode;
//	}
}
