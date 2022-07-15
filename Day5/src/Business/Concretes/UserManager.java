package Business.Concretes;

import Business.Abstracts.UserService;
import Core.Abstracts.GoogleLogInService;
import DataAccess.Abstracts.UserDao;
import Entities.Concretes.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

	UserDao userDao;
	GoogleLogInService googleLogInService;

	private ArrayList<String> emailList = new ArrayList<String>();
	private ArrayList<String> paswordList = new ArrayList<String>();

	//regex
	public static boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

	public static boolean isEmailValidOnClick() {

		return true;
	}

	public UserManager(UserDao userDao, GoogleLogInService googleLogInService) {
		super();
		this.userDao = userDao;
		this.googleLogInService=googleLogInService;
	}

	@Override
	public void register(String email, String password, User user) {
		if (isEmailValid(email) != true) {
			System.out.println("Email address is not valid. Please enter a valid e-mail address.");
			return;
		} else if (user.geteMail().equals(emailList.contains(email))) {
			System.out.println("This email already registered. Please try another one.");
			return;
		} else if (password.length() < 6) {
			System.out.println("Password must have a minimum of 6 characters.");
			return;
		} else if (user.getFirstName().length() < 2) {
			System.out.println("Name must contain at least 2 characters.");
			return;
		} else if (user.getLastName().length() < 2) {
			System.out.println("Surname must contain at least 2 characters.");
			return;
		} else {
			System.out.println("Registration Successful.");

			emailList.add(email);
			paswordList.add(password);
			userDao.add(user);
		}
	}

	@Override
	public void logIn(String email, String password) {
		if (isEmailValidOnClick()) {
			System.out.println("Confirm your email before login.");
		}
		if (isEmailValid(email) && paswordList.contains(password)) {
			System.out.println("Login success");
			return;
		} else if (!paswordList.contains(password) || !isEmailValid(email)) {
			System.out.println("Login failed. Please check again.");
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void googleRegister(User user) {
		googleLogInService.googleAccountLogIn(user.geteMail());
		return;
		
	}
}
