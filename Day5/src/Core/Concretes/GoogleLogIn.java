package Core.Concretes;

import Core.Abstracts.GoogleLogInService;

public class GoogleLogIn implements GoogleLogInService{

	@Override
	public void googleAccountLogIn(String message) {
		System.out.println(message);
		
	}
}
