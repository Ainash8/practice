package controller;

import java.util.HashMap;
import java.util.Map;

import org.jruby.compiler.ir.operands.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student theStudent = new Student();

		model.addAttribute("student", theStudent);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("the Student : " + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
