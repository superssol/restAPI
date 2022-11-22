package info.thecodinglive.model;

import lombok.Data;

@Data
public class Todo {
	
	private long id;
	private String title;
	
	public Todo(long id, String title) {
		this.id = id;
		this.title = title;
	}
	
}
