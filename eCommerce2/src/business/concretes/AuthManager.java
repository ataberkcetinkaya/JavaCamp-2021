package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import entities.concretes.LoginDto;
import entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.getEmail()) == false && core.utils.Utils.emailValidate(user.getEmail())) {			
		userService.add(user);
	}
	System.out.println("registration failed");
	}
	@Override

	public void verify(User user, String token) {
		if(user!=null && token.length()>20) {
			User exisUser=userService.get(user.getEmail());
			exisUser.setIsVerify(true);
			
			userService.update(exisUser);
			System.out.println("verified");
		}
		System.out.println("not verified here.");
		
	}

	@Override
	public boolean userExists(String email) {
		User user = userService.get(email);
		
		if(user==null) {
			return false;
		}else {
			System.out.println("Email is already registered. " + email);
			return true;
		}
		
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());
		
		if(user != null && user.getPassword().equals(dto.getPassword())) {
			
			System.out.println("Login success.");
		}else {
			System.out.println("Login failed.");
		}
		
	}
	
	public boolean userValidate(User user) {
		if (user!=null && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean passwordValidate(String password) {
		if(password.length() >= 6) {
			return true;
		}
		else {
		System.out.println("Password with min. 6 characters");
		return false;
		}
	}

}
