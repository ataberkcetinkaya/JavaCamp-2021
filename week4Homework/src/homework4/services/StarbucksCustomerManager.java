package homework4.services;

import homework4.abstracts.CustomerManager;
import homework4.entities.Customer;
import homework4.interfaces.CustomerCheckService;
import homework4.interfaces.Result;
import homework4.utils.CheckServiceUtils;

public class StarbucksCustomerManager extends CustomerManager {
	
	private CustomerCheckService customerCheckService;
	
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}


	@Override
	public void add(Customer customer) {

		Result result =  CheckServiceUtils.runCheckServices(new Result[] {
				customerCheckService.CheckPersonIdentity(customer), 
				customerCheckService.CheckIfSmallerAgeThan(customer, 15)
				});
		
		if(!result.isSuccess()) {
			System.out.println(result.getMessage());
			return;
		}
		
		super.add(customer);
	}
}
