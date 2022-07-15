package week3Homework;

public class InstructorManager extends UserManager {
    @Override
    public void add(User user) {
        System.out.println("Instructor : "+ user.getFirstName() +" "+ user.getLastName() + " Saved.");

    }

    @Override
    public void delete(User user) {
        System.out.println("Instructor : "+ user.getFirstName() +" "+ user.getLastName() + " Deleted.");
    }

    @Override
    public void update(User user) {
        System.out.println("Instructor : "+ user.getFirstName() +" "+ user.getLastName() + " Updated.");

    }
    public void getAll(Instructor[] instructors){
        for (Instructor instructor:instructors){
            System.out.println(instructor.getFirstName() +" "+ instructor.getLastName());
        }
    }
}