package info.thecodinglive.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.util.UriComponents;

import lombok.Data;

public class TodoResource extends RepresentationModel<TodoResource>{
	
	private String title;
	
	public TodoResource() {		
	}

	public TodoResource(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
