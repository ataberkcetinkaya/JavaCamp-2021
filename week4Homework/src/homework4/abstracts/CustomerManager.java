package homework4.abstracts;

import homework4.entities.Customer;
import homework4.interfaces.CustomerService;

public abstract class CustomerManager implements CustomerService {

	@Override
	public void add(Customer customer) {
		System.out.println(customer.getFirstName() + "Save complete.");
	}

}
