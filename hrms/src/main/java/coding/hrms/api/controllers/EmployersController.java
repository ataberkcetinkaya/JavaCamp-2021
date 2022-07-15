package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.Business.abstracts.EmployersService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	EmployersService employersService;
	
	@Autowired
	public EmployersController(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return employersService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return employersService.add(employer);
	}
}