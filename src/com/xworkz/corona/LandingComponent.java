package com.xworkz.corona;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LandingComponent {
	
	private  List<String> states;

	public LandingComponent() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("invoked init-mrthod");
		this.states=new ArrayList<String>();
		this.states.add("Karnataka");
		this.states.add("Kerala");
		this.states.add("Goa");
		this.states.add("Tamilnadu");
		this.states.add("Up");

	}
	
	@RequestMapping("/landing.do")
	public  String landingPage(Model model) {
		System.out.println("invoked landingPage");
		model.addAttribute("states",this.states);
		return "corona";
	}
	private void destroy() {
      System.out.println("invoked pre-destroy");
      this.states=null;
	}
	
	
}
