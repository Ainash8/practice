package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm()
	{
		return "hello-world";
	}
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		System.out.println("hi");
		return "welcome";
	}
	
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest req,Model model)
	{
		
		String theName = req.getParameter("studentName");
		theName = theName.toUpperCase();
		String result = "Yo!" + theName;
		model.addAttribute("message",result);
		return "welcome";
	}
	
	@RequestMapping("/processFormVersion3")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model)
	{
		theName = theName.toUpperCase();
		String result = "Hey my friend..! "  + theName;
		model.addAttribute("message",result);
		return "welcome";
	}
	
}
