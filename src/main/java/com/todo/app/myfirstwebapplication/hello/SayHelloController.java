package com.todo.app.myfirstwebapplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // tell spring it is a bean and it handles web requests
public class SayHelloController {
	
	
	@RequestMapping("/say-hello") //map the url in this
	@ResponseBody //return the response as is 
	public String sayHello() {
		return "Hello What are you doing today?";
	}
	
	
	
	@RequestMapping("/say-hello-html") //map the url in this
	@ResponseBody //return the response as is 
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> First html</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>My first spring boot</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
		
	}
	
	
	
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
