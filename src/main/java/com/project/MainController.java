package com.project;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Test123 index() {
		Test123 t = new Test123();
		t.setName("test");
		return t;
	}
}

class Test123 {
	private String Name;

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}