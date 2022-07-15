package week3Homework;

public class StudentManager extends UserManager{
    @Override
    public void add(User user) {
        System.out.println("Student : "+ user.getFirstName() +" Saved.");

    }

    @Override
    public void delete(User user) {
        System.out.println("Student : "+ user.getFirstName() +"  Deleted.");
    }

    @Override
    public void update(User user) {
        System.out.println("Student : "+ user.getFirstName() +" Updated.");

    }
    public void getAll(Student[] students){
        for (Student student:students){
            System.out.println(student.getFirstName());
        }
    }
}