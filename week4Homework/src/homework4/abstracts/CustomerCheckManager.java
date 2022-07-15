package homework4.abstracts;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;


import homework4.entities.Customer;
import homework4.interfaces.CustomerCheckService;
import homework4.interfaces.Result;

public class CustomerCheckManager implements CustomerCheckService {

	@Override
	public Result CheckPersonIdentity(Customer customer) {
		
		return new homework4.models.Result(true);
	}

	@Override
	public Result CheckIfSmallerAgeThan(Customer customer, int age) {
		LocalDate todayDateTime = LocalDate.now();
		LocalDate birthDate = customer.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int yearDifference = Period.between(birthDate, todayDateTime).getYears();
		if(yearDifference < age) {
			return new homework4.models.Result(false, age + " cant be younger");
		}
		return new homework4.models.Result(true);
	}

}
