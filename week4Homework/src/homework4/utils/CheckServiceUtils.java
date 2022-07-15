package homework4.utils;

import homework4.interfaces.Result;

public class CheckServiceUtils {
	public static Result runCheckServices(Result[] customerCheckServices) {
		for (Result customerCheckService : customerCheckServices) {
			if(!customerCheckService.isSuccess()) {
				return customerCheckService;
			}
		}
		return new homework4.models.Result(true);
	}
}

