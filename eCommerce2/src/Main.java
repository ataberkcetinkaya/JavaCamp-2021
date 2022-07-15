import java.util.List;
import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.amazonEmail.AmazonMailManagerAdapter;
import core.googleEmail.GoogleMailManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		AuthManager authManager = new AuthManager(new UserManager(inMemoryUserDao));
		
		User berk = new User(1,"Berk","Ç.","berk@gmail.com","123456b",true);
		User sena = new User(2,"Sena","Y.","sena@gmail.com","123456s",true);
		
		authManager.register(berk);
		
		UserManager userManager = new UserManager(inMemoryUserDao);
		//userManager.update(sena);
		userManager.getAll();
		
	}

}
