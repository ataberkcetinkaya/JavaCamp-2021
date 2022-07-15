package week3Homework;

public class UserManager {
    public void add(User user){
        System.out.println(user.getFirstName() +": Saved.");
    }
    public void addMultiple(User[] users){
        for (User user:users){
            add(user);
        }
    }
    public void delete(User user){
        System.out.println(user.getFirstName() +": Deleted.");
    }
    public void update(User user){
        System.out.println(user.getFirstName() +": Updated.");
    }
}