package homework4.interfaces;

import homework4.entities.Customer;
import homework4.interfaces.Result;

public interface CustomerCheckService {
	Result CheckPersonIdentity(Customer customer);
	Result CheckIfSmallerAgeThan(Customer customer, int age);
}
