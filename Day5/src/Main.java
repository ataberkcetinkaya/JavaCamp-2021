import Business.Abstracts.UserService;
import Business.Concretes.UserManager;
import Core.Concretes.GoogleLogIn;
import DataAccess.Abstracts.UserDao;
import DataAccess.Concretes.HibernateDao;
import Entities.Concretes.User;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService = new UserManager(new HibernateDao(),new GoogleLogIn());
		
		User user1 = new User(1, "Ataberk", " �.", "berk@gmail.com", "PythonisBetter");
		userService.register("berk@gmail.com", "PythonisBetter", user1);

		userService.logIn("berk@gmail.com", "PythonisBetter");
		
		userService.googleRegister(user1);
		
		System.out.println("*******************************************************************************");
		
		User user2 = new User(2, "Sena", " Y.", "sena@gmail.com", "lilSena123");
		userService.register("sena@gmail.com", "lilSena123", user2);

		userService.logIn("sena@gmail.com", "lilSena123");
		
		userService.googleRegister(user2);
	}

}
