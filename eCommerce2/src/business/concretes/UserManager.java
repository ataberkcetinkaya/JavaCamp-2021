package business.concretes;

import java.util.List;
import business.abstracts.UserService;
import core.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private EmailService emailservice;
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		this.emailservice = emailservice;
	}

	@Override
	public void add(User user) {
		
		if(userValidate(user)) {
			userDao.add(user);
			
			emailservice.send(user.getEmail(), "registered");
		}
		
		
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}
		
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	
	}

	@Override
	public List<User> getAll() {
			for (User user : userDao.getAll()) {
				System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
			}
			return userDao.getAll();
	}
	public boolean userValidate(User user) {
		if(user.getFirstName().length() > 2 && user.getLastName().length() > 2) {
			return true;
		}
		System.out.println("Min. 2 characters");
		return false;
	}
}
