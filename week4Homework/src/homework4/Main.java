package homework4;

import java.util.GregorianCalendar;

import homework4.adapters.MernisAdapter;
import homework4.entities.Customer;
import homework4.interfaces.CustomerService;
import homework4.services.StarbucksCustomerManager;

public class Main {

	public static void main(String[] args) {

		Customer enginCustomer = new Customer();
		enginCustomer.setId(1);
		enginCustomer.setIdentityNumber("0000011111");
		enginCustomer.setFirstName("Berk");
		enginCustomer.setLastName("C.");
		enginCustomer.setBirthDate(new GregorianCalendar(1998,1,1).getTime());
		
		CustomerService customerService = new StarbucksCustomerManager(new MernisAdapter());
		customerService.add(enginCustomer);
	}

}
