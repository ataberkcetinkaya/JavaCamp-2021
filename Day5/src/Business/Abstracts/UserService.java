package Business.Abstracts;

import java.util.ArrayList;
import java.util.List;

import Entities.Concretes.User;

public interface UserService {

	void register(String email, String password, User user);
	
	void logIn(String email, String password);
	
	List<User> getAll();
	
	ArrayList<String> emailList=new ArrayList<String>();
	
	void googleRegister(User user);
	
}
