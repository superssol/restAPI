package info.thecodinglive.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/todo")
	public Todo basic() {
		return new Todo(counter.incrementAndGet(), "라면사오기");
		
	}
	
	@RequestMapping(value = "/todop", method = RequestMethod.POST)
	public Todo postbasic(@RequestParam(value = "todoTitle") String todoTitle) {
		return new Todo(counter.incrementAndGet(), todoTitle);
		
	}
	
	@RequestMapping(value = "/todor", method = RequestMethod.POST)
	public ResponseEntity<Todo> postbasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle) {
		return new ResponseEntity<>(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED) ;
		
	}
	
	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
	public Todo getPath(@PathVariable int todoId) {
		
		Todo todo = new Todo(1L, "문서쓰기");
		Todo todo2 = new Todo(2L, "문서쓰기2");
		Todo todo3 = new Todo(3L, "문서쓰기3");
		
		Map<Integer, Todo> todoMap = new HashMap<>();
		todoMap.put(1, todo);
		todoMap.put(2, todo2);
		todoMap.put(3, todo3);
		
		return todoMap.get(todoId);		
	}
	
	@RequestMapping(value = "/todoh", method = RequestMethod.GET)
	public ResponseEntity<TodoResource> geth(@RequestParam(value = "todoTitle") String todoTitle) {
		TodoResource tr = new TodoResource(todoTitle);
		tr.add(linkTo(methodOn(BasicController.class).geth(todoTitle)).withSelfRel());
		
		return new ResponseEntity<>(tr, HttpStatus.OK) ;
	}
}
