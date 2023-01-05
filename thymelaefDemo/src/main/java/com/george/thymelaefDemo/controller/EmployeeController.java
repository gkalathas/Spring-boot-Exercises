package com.george.thymelaefDemo.controller;

import java.util.List;

import com.george.thymelaefDemo.entity.Employee;
import com.george.thymelaefDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addingForm";
	}


	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/list-employees";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
		//get the employee from the service
		Employee employee = employeeService.findById(theId);

		//set employee as a model to pre-populate the form
		model.addAttribute("employee", employee);

		//send over to our form
		return "addingForm";
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/list-employees";
	}
}









