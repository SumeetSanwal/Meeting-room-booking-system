package net.javaguides.booking.model;

public class Event {
	private int id;
	private String room;
	private String to;
	private String from;
	private String dt;
	private String path;
	private String description;
	
	public Event() {
	}
	
	public Event(int id, String room, String e_from, String e_to, String dt, String description) {
		super();
		this.id=id;
		this.room=room;
		this.from=e_from;
		this.to=e_to;
		this.dt=dt;
		this.description=description;	
		
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
