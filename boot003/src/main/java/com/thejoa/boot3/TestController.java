package com.thejoa.boot3;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {

	@GetMapping("/test")
	public String test() {return "test";}
}
